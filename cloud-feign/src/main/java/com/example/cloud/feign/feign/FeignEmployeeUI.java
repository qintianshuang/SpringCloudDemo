package com.example.cloud.feign.feign;

import com.example.cloud.web.bean.employee.Employee;
import com.example.cloud.web.bean.employee.ExpressBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/***
 * 与Ribbon具有类似功能
 * 用于外部发起的请求
 * 具有软负载均衡功能，轮询机制
 */
@FeignClient(value = "cloud-app")
public interface FeignEmployeeUI {

    @GetMapping(value = "/queryEmployeeByName")
    String queryEmployeeByName(@RequestParam("name") String name);

    @PostMapping(value = "/creatEmployeeList",consumes = "application/json")
    String creatEmployeeList(@RequestBody List<Employee> expressBeans);

    @PostMapping(value = "/creatEmployeeInfo", consumes = "application/json")
    public String creatEmployeeInfo(@RequestBody Employee employee);
}
