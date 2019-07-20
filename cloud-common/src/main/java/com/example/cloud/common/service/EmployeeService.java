package com.example.cloud.common.service;

import com.example.cloud.common.io.Employee;
import com.example.cloud.common.io.ExpressBean;

import java.util.List;

public interface EmployeeService {

    List<Employee> queryEmployee();

    List<ExpressBean> queryExpress();

    void insertExpress(List<ExpressBean> expressBeans);
}
