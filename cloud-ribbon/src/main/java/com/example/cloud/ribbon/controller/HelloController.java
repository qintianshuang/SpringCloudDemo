package com.example.cloud.ribbon.controller;

import com.example.cloud.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/index")
    public String hi(@RequestParam String name) {
        System.out.println("--------");
        return helloService.HiService(name);
    }
}
