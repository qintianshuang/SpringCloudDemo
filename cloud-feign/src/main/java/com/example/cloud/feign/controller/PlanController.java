package com.example.cloud.feign.controller;

import com.example.cloud.common.util.PoiUtils;
import com.example.cloud.feign.feign.FeignUI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/***
 * Swagger注解
 * swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
 *
 * @Api：修饰整个类，描述Controller的作用
 * @ApiOperation：描述一个类的一个方法，或者说一个接口
 * @ApiParam：单个参数描述
 * @ApiModel：用对象来接收参数
 * @ApiProperty：用对象接收参数时，描述对象的一个字段
 * @ApiResponse：HTTP响应其中1个描述
 * @ApiResponses：HTTP响应整体描述
 * @ApiIgnore：使用该注解忽略这个API
 * @ApiError ：发生错误返回的信息
 * @ApiImplicitParam：一个请求参数
 * @ApiImplicitParams：多个请求参数
 */
@Api(value = "平台模型", description = "平台入口")
@RestController
public class PlanController {

    @Autowired
    private FeignUI feignUI;

    @Value("${server.port}")
    public String port;

    @Value("${app.hello}")
    private String hello;


    @ApiOperation(value = "计划信息", notes = "RestFul风格的请求")
    //@ApiImplicitParams({@ApiImplicitParam(name = "classNo", value = "班级编号", required = true, dataType = "String"),
    //})
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name") String name, @RequestParam(value = "classNo") String classNo) {
        System.out.println("++++++++++++++");
        return feignUI.sayHiFromClientOne(name, classNo);
    }

    @ApiOperation(value = "下载文件", notes = "文件导出",produces="application/octet-stream")
    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response) throws Exception {
        String fileName = "文件下载";
        Workbook workbook = new HSSFWorkbook();
        PoiUtils.outExcel(response, fileName, workbook);
    }
}
