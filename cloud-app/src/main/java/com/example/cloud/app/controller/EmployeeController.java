package com.example.cloud.app.controller;

import com.example.cloud.common.config.Logger;
import com.example.cloud.common.io.Employee;
import com.example.cloud.common.io.ExpressBean;
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

    @GetMapping(value = "/queryAppointEmployee")
    public String queryAppointEmployee(@RequestParam String name) {
        Employee employee = empService.queryAppointEmployee(name);
        return null;
    }

    @GetMapping(value = "/queryEmployeeList")
    public List<Employee> queryEmployeeList() {
        log.debug("我被调用了");
        List<Employee> employees = empService.queryEmployeeList();
        log.debug("employees||" + employees);
        return employees;
    }

    @PostMapping(value = "/creatEmployeeList", consumes = "application/json")
    public void creatEmployeeList(@RequestBody List<ExpressBean> expressBeans) {
            empService.insertExpress(expressBeans);
    }
}
