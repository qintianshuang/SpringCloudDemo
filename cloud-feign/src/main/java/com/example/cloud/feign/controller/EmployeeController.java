package com.example.cloud.feign.controller;

import com.example.cloud.common.config.Logger;
import com.example.cloud.feign.feign.FeignEmployeeUI;
import com.example.cloud.web.bean.employee.Employee;
import com.example.cloud.web.bean.employee.ExpressBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "人员信息", description = "人员信息")
@RestController
public class EmployeeController {

    private final static Logger log = Logger.getLogger(EmployeeController.class);

    @Autowired
    FeignEmployeeUI feignUI;

    @ApiOperation(value = "查询指定人员信息", notes = "查询指定人员信息",produces="application/octet-stream")
    @GetMapping(value = "/queryAppointEmployee")
    public String queryAppointEmployee(@RequestParam String name) {
        return feignUI.queryAppointEmployee(name);
    }


    @ApiOperation(value = "新增人员信息", notes = "新增人员信息",produces="application/octet-stream")
    @PostMapping(value = "/creatEmployeeList",consumes = "application/json")
    public String creatEmployeeList() {

        List<ExpressBean> expressBeans = new ArrayList<>();
        expressBeans.add(new ExpressBean("","小春","12","外卖","微课有限公司"));
        expressBeans.add(new ExpressBean("","小红","13","文员","墨色有限公司"));
        expressBeans.add(new ExpressBean("","小绿","14","工程师","太阳有限公司"));
        expressBeans.add(new ExpressBean("","小紫","15","教练","噢噢有限公司"));

        return feignUI.creatEmployeeList(expressBeans);
    }

    @ApiOperation(value = "获取员工信息", notes = "获取员工信息",produces="application/octet-stream")
    @GetMapping(value = "/queryEmployeeList")
    public List<Employee> queryEmployeeList(){
        System.out.println("list被调用了");
        return feignUI.queryEmployeeList();
    }
}