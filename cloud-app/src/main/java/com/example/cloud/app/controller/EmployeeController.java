package com.example.cloud.app.controller;

import com.example.cloud.common.io.Employee;
import com.example.cloud.common.io.ExpressBean;
import com.example.cloud.service.config.LogUtils;
import com.example.cloud.service.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *
 */
@RestController
public class EmployeeController {


    @Autowired
    @Qualifier("empService")
    private IEmployeeService empService;

    @GetMapping(value = "/queryAppointEmployee")
    public String queryAppointEmployee(@RequestParam String name) {
        return null;
    }

    @GetMapping(value = "/queryEmployeeList")
    public List<Employee> queryEmployeeList() {
        System.out.println("我被调用了");
        List<Employee> employees = empService.queryEmployee();
        System.out.println(employees);
        return employees;
    }

    @GetMapping(value = "/queryEmployee")
    public List<ExpressBean> queryEmployee() {
        List<ExpressBean> expressBeanList = empService.queryExpress();
        return expressBeanList;
    }

    @PostMapping(value = "/creatEmployee", consumes = "application/json")
    public String creatEmployee(@RequestBody List<ExpressBean> expressBeans) {
        if (!CollectionUtils.isEmpty(expressBeans)) {
            for (ExpressBean expressBean : expressBeans) {
                System.out.println(expressBean.toString());
            }
            empService.insertExpress(expressBeans);
        }
        return null;
    }
}
