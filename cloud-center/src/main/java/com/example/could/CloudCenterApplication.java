package com.example.could;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//申明此处为服务注册中心
public class CloudCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCenterApplication.class, args);
    }

}
