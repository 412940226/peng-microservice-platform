package com.peng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PengEureka9002Application {

	public static void main(String[] args) {
		SpringApplication.run(PengEureka9002Application.class, args);
	}

}
