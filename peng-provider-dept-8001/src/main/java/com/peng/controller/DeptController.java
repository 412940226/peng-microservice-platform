package com.peng.controller;

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

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping("/dept/get/{deptId}")
    public Dept get(@PathVariable("deptId") Long deptId) {
        return deptService.get(deptId);
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.list();
    }
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
}
