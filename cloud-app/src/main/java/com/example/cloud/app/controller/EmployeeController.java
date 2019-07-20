package com.example.cloud.app.controller;

import com.example.cloud.common.io.Employee;
import com.example.cloud.common.io.ExpressBean;
import com.example.cloud.common.service.EmployeeService;
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
    private EmployeeService employeeService;

    @GetMapping(value = "/index")
    public Object home(@RequestParam(value = "name") String name, @RequestParam(value = "classNo") String classNo) {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    @GetMapping(value = "/list")
    public List<Employee> queryEmployee() {
        System.out.println("我被调用了");
        List<Employee> employees = employeeService.queryEmployee();
        System.out.println(employees);
        return employees;
    }

    @GetMapping(value = "/query")
    public List<ExpressBean> query() {
        List<ExpressBean> expressBeanList = employeeService.queryExpress();
        return expressBeanList;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public String addHelloPort(@RequestBody List<ExpressBean> expressBeans) {
        if (!CollectionUtils.isEmpty(expressBeans)) {
            for (ExpressBean expressBean : expressBeans) {
                System.out.println(expressBean.toString());
            }
            employeeService.insertExpress(expressBeans);
        }
        return null;
    }
}
