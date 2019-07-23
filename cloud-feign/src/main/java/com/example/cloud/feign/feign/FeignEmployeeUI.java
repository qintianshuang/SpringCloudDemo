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

    @GetMapping(value = "/queryAppointEmployee")
    String queryAppointEmployee(@RequestParam("name") String name);

    @GetMapping(value = "/queryEmployee")
    List<ExpressBean> queryEmployee();

    @PostMapping(value = "/creatEmployee",consumes = "application/json")
    String creatEmployee(@RequestBody List<ExpressBean> expressBeans);

    @GetMapping(value = "/queryEmployeeList")
    public List<Employee> queryEmployeeList();
}
