package com.example.cloud.app.controller;

import com.example.cloud.common.config.Logger;
import com.example.cloud.common.io.Employee;
import com.example.cloud.common.io.ExpressBean;
import com.example.cloud.server.service.impl.EmployeeServiceImpl;
import com.example.cloud.service.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;
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
        return null;
    }

    @GetMapping(value = "/queryEmployeeList")
    public List<Employee> queryEmployeeList() {
        log.debug("我被调用了");
        List<Employee> employees = empService.queryEmployee();
        log.debug("employees||" + employees);
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
                log.debug("expressBean.toString()||" +expressBean.toString());
            }
            empService.insertExpress(expressBeans);
        }
        return null;
    }
}
