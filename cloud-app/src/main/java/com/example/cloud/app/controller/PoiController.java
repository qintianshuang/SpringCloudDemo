package com.example.cloud.app.controller;

import com.example.cloud.common.config.Logger;
import com.example.cloud.common.util.PoiUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

/***
 *
 */
@RestController
public class PoiController {

    private final static Logger log = Logger.getLogger(PoiController.class);


    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response) throws Exception {
        String fileName = "文件下载";
        Workbook workbook = new HSSFWorkbook();
        PoiUtils.outExcel(response, fileName, workbook);
    }
}
