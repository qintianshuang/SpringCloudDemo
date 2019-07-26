package com.example.cloud.feign.controller;

import com.example.cloud.common.config.Logger;
import com.example.cloud.feign.feign.FeignEmployeeUI;
import com.example.cloud.web.bean.employee.Employee;
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

    @ApiOperation(value = "根据名称查询指定人员信息", notes = "根据名称查询指定人员信息", produces = "application/octet-stream")
    @GetMapping(value = "/queryEmployeeByName")
    public String queryEmployeeByName(@RequestParam String name) {
        return feignUI.queryEmployeeByName(name);
    }

    @ApiOperation(value = "新增人员集合", notes = "新增人员集合", produces = "application/octet-stream")
    @PostMapping(value = "/creatEmployeeList", consumes = "application/json")
    public String creatEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("", "小红", 12, "420528199901172431", "湖北省宜昌市长阳县", "深圳市宝安区新安一路晶美花园", "18665892257", "2065114232@qq.com"));
        return feignUI.creatEmployeeList(employeeList);
    }

    @ApiOperation(value = "新增人员信息", notes = "新增人员信息", produces = "application/octet-stream")
    @PostMapping(value = "/creatEmployeeInfo", consumes = "application/json")
    public String creatEmployeeInfo(@RequestBody Employee employee) {
        return feignUI.creatEmployeeInfo(employee);
    }
}