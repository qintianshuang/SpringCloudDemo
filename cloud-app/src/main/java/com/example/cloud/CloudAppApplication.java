package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient //表明自己属于一个生产者
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = "com.example.cloud")
@SpringBootApplication
public class CloudAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAppApplication.class, args);
    }

}
