package com.peng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class PengZuulGateway6001Application {

    public static void main(String[] args) {
        SpringApplication.run(PengZuulGateway6001Application.class, args);
    }

}
