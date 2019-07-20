package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudRibbonApplication.class, args);
    }

    /***
     * Ribbon的使用情景：
     * 1.存在与服务之间的调用
     * 2.具有软负载均衡的功能
     * 3.采用restTemplate技术
     * 4.维护了一个服务端列表
     * 5.基于Http和TCP的客服端负载均衡工具
     * @return
     */
    @Bean
    @LoadBalanced//开启客户端负载均衡
    RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
