package com.example.cloud.service.service;

import com.example.cloud.common.io.Employee;
import com.example.cloud.common.io.ExpressBean;

import java.util.List;

public interface IEmployeeService {

    List<Employee> queryEmployeeList();

    void insertExpress(List<ExpressBean> expressBeans);

    Employee queryAppointEmployee(String name);
}