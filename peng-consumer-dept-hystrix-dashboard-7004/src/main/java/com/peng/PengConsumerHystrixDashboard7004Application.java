package com.peng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class PengConsumerHystrixDashboard7004Application {

	/**
	 * 访问地址: http://localhost:7004/hystrix
	 * 监控地址：http://localhost:8004/hystrix.stream
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PengConsumerHystrixDashboard7004Application.class, args);
	}

}
