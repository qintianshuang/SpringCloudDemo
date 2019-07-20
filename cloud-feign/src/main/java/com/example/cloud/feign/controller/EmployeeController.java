package com.example.cloud.feign.controller;

import com.example.cloud.feign.bean.Employee;
import com.example.cloud.feign.bean.ExpressBean;
import com.example.cloud.feign.feign.FeignUI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "年度计划", description = "年度计划")
@RestController
public class EmployeeController {

    @Autowired
    FeignUI feignUI;

    @ApiOperation(value = "查询指定人员信息", notes = "查询指定人员信息",produces="application/octet-stream")
    @GetMapping(value = "/hi")
    public String sayHelloPort(@RequestParam String name) {
        return feignUI.sayHelloPort(name);
    }


    @ApiOperation(value = "新增人员信息", notes = "新增人员信息",produces="application/octet-stream")
    @PostMapping(value = "/add",consumes = "application/json")
    public String addHelloPort() {

        List<ExpressBean> expressBeans = new ArrayList<>();
        expressBeans.add(new ExpressBean("11111","小春","12","外卖","微课有限公司"));
        expressBeans.add(new ExpressBean("22222","小红","13","文员","墨色有限公司"));
        expressBeans.add(new ExpressBean("33333","小绿","14","工程师","太阳有限公司"));
        expressBeans.add(new ExpressBean("44444","小紫","15","教练","噢噢有限公司"));

        return feignUI.addHelloPort(expressBeans);
    }

    @ApiOperation(value = "查询人员信息", notes = "查询人员信息",produces="application/octet-stream")
    @GetMapping(value = "/query")
    public List<ExpressBean> query() {
        System.out.println("query被调用了");
        return feignUI.query();
    }

    @ApiOperation(value = "获取员工信息", notes = "获取员工信息",produces="application/octet-stream")
    @GetMapping(value = "/list")
    public List<Employee> queryEmployee(){
        System.out.println("list被调用了");
        return feignUI.queryEmployee();
    }
}