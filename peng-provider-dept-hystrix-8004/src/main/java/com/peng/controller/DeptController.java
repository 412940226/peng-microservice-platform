package com.peng.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.peng.entity.Dept;
import com.peng.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    private final static Logger logger = LoggerFactory.getLogger(DeptController.class);
    @Autowired private DeptService deptService;
    @Qualifier("discoveryClient")
    @Autowired private DiscoveryClient discoveryClient;

    @GetMapping("/dept/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        logger.info("**********" + list);
        List<ServiceInstance> srvList = discoveryClient.getInstances("PENG-PROVIDER-DEPT");
        for (ServiceInstance element : srvList) {
            logger.info("【服务ID】："+element.getServiceId() + "，【服务IP】：" + element.getHost() + "，【服务端口】：" + element.getPort() + "，【服务URI】："+element.getUri());
        }
        return this.discoveryClient;
    }


    @RequestMapping(value = "/dept/get/{deptId}", method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("deptId") Long deptId) {

        Dept dept = this.deptService.get(deptId);

        if (null == dept) {
            throw new RuntimeException("该ID：" + deptId + "没有没有对应的信息");
        }

        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("deptId") Long deptId) {
        return new Dept().setDeptId(deptId).setDeptName("该ID：" + deptId + "没有没有对应的信息,null--@HystrixCommand")
                .setDeptSource("no this database in MySQL");
    }
}
