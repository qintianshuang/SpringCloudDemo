package com.example.cloud.feign.feign;

import com.example.cloud.feign.bean.Employee;
import com.example.cloud.feign.bean.ExpressBean;
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
public interface FeignUI {

    @GetMapping(value = "/index")
    String sayHiFromClientOne(@RequestParam(value = "name") String name,@RequestParam(value = "classNo") String classNo);

    @GetMapping(value = "/hi")
    String sayHelloPort(@RequestParam("name") String name);

    @GetMapping(value = "/query")
    List<ExpressBean> query();

    @PostMapping(value = "/add",consumes = "application/json")
    String addHelloPort(@RequestBody List<ExpressBean> expressBeans);

    @GetMapping(value = "/list")
    public List<Employee> queryEmployee();
}
