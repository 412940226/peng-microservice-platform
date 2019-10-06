package com.peng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //启动eureka服务
public class PengEureka9001Application {

	public static void main(String[] args) {
		SpringApplication.run(PengEureka9001Application.class, args);
	}

}
