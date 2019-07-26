package com.example.cloud.app.controller;

import com.example.cloud.common.config.Logger;
import com.example.cloud.common.io.Employee;
import com.example.cloud.service.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/***
 *
 */
@RestController
public class EmployeeController {

    private final static Logger log = Logger.getLogger(EmployeeController.class);


    @Autowired
    @Qualifier("empService")
    private IEmployeeService empService;

    @GetMapping(value = "/queryEmployeeByName")
    public List<Employee> queryEmployeeByName(@RequestParam String name) {
        List<Employee> employees = empService.queryEmployeeByName(name);
        return employees;
    }

    @PostMapping(value = "/creatEmployeeList", consumes = "application/json")
    public void creatEmployeeList(@RequestBody List<Employee> employeeList) {
            empService.insertEmployeeList(employeeList);
    }

    @PostMapping(value = "/creatEmployeeInfo", consumes = "application/json")
    public void creatEmployeeInfo(@RequestBody Employee employee) {
        empService.creatEmployeeInfo(employee);;
    }
}
