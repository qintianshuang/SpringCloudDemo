package com.example.cloud.common.util;

import com.example.cloud.common.annotation.ExcelAnnotation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PoiUtils {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    private static final String STRING_TYPE = "STRING";
    private static final String DATE_TYPE = "DATE";
    private static final String NUMBER_TYPE = "NUMBER";

    /**
     * 判断Excel的版本,获取Workbook
     *
     * @param in
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(InputStream in, MultipartFile file) throws IOException {
        Workbook wb = null;
        if (file.getName().endsWith(EXCEL_XLS)) {  //Excel 2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    /**
     * 判断文件是否是excel
     *
     * @throws Exception
     */
    public static void checkExcelVaild(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("文件不存在");
        }
        if (!(!file.isEmpty() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
            throw new Exception("文件不是Excel");
        }
    }


    /***
     *输出文件到前台
     * @param response
     * @param fileName
     * @param workBook
     */
    public static void outExcel(HttpServletResponse response, String fileName, Workbook workBook) throws IOException {

        Sheet sheet1 = workBook.createSheet("sheet1");

        Row row = workBook.getSheet("sheet1").createRow(0);    //创建第一行
        for (int i = 0; i < 10; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue("测试数据" + i);
        }



        OutputStream out = null;
        try {
            out = response.getOutputStream();
            response.reset();
            response.setContentType("application/octet-stream;charset=iso-8859-1");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes(),"iso-8859-1") + ".xls");
            workBook.write(out); // 输出流控制workbook

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.flush();
            out.close();
        }
    }

    /***
     *读取文件
     * @param file
     * @param clazz
     */
    public static <T extends Object> List<T> readExcel(MultipartFile file, Class<T> clazz, String sheetName) throws Exception {
        PoiUtils.checkExcelVaild(file);
        InputStream input = file.getInputStream();
        Workbook workbook = PoiUtils.getWorkbok(input, file);
        int maxCol = 0;
        List<T> list = new ArrayList<T>();
        Sheet sheet = null;
        try {
            sheet = workbook.getSheet(sheetName);
            if (!sheetName.trim().equals("")) {
                sheet = workbook.getSheet(sheetName);// 如果指定sheet名,则取指定sheet中的内容.
            }
            if (sheet == null) {
                sheet = workbook.getSheetAt(0); // 如果传入的sheet名不存在则默认指向第1个sheet.
            }
            int rows = sheet.getPhysicalNumberOfRows();
            T job = null;
            boolean isNull = false;
            boolean isNotNull = false;
            int count = 0;
            ExcelAnnotation excelAnnotation = null;
            for (int i = 1; i < rows; i++) {
                Row row = sheet.createRow(i);
                job = clazz.newInstance();
                Field[] fields = job.getClass().getDeclaredFields();
                for (Field field : fields) {
                    Cell cell = null;
                    if (field.isAnnotationPresent(ExcelAnnotation.class)) {
                        // 对象的属性的访问权限设置为可访问
                        field.setAccessible(true);
                        excelAnnotation = field.getAnnotation(ExcelAnnotation.class);
                        //读取数据起始行
                        int initIndex = excelAnnotation.initRow();
                        if (i < initIndex) {
                            break;
                        }
                        //获取对应的列号
                        int column = excelAnnotation.column();
                        try {
                            cell = row.getCell(column);
                        } catch (NullPointerException e) {
                            continue;
                        }
                        if (cell == null) {
                            isNull = true;
                        }
                    }
                    readCell(field, job, row, cell, excelAnnotation);
                    isNotNull = true;
                }
                if (isNotNull) {
                    list.add(job);
                } else if (!isNull && !isNotNull) {
                    count++;
                }
                if (count > 10) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return list;
    }

    /***
     * 获取文件数据持久化
     * @param field
     * @param job
     * @param row
     * @param cell
     * @param excelAnnotation
     * @param <T>
     * @throws Exception
     */
    private static <T extends Object> void readCell(Field field, T job, Row row, Cell cell, ExcelAnnotation excelAnnotation) throws Exception {
        boolean isEmpty = excelAnnotation.isEmpty();
        String indexColumn = PoiUtils.getIndexColumn(row, cell);
        String dataType = excelAnnotation.format().toUpperCase();
        if (cell != null && cell.getCellTypeEnum().equals(CellType.BLANK)) {
            switch (dataType) {
                case STRING_TYPE:
                    cell.setCellType(CellType.STRING);
                    field.set(job, cell.getStringCellValue());
                    break;
                case DATE_TYPE:
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        if (cell.getCellTypeEnum().equals(CellType.STRING)) {
                            sdf.parse(cell.getStringCellValue());
                            field.set(job, cell.getStringCellValue());
                        } else {
                            cell.setCellType(CellType.STRING);
                            String data = sdf.format(cell.getStringCellValue());
                            field.set(job, data);
                        }
                    } catch (Exception e) {
                        throw new Exception(indexColumn + "-时间格式错误");
                    }
                    break;
                case NUMBER_TYPE:
                    cell.setCellType(CellType.STRING);
                    boolean isDigits = cell.getStringCellValue().matches("^[0-9]+(.[0-9]{2})?$");
                    if (!isDigits) {
                        throw new Exception(indexColumn + "-数字格式错误");
                    }
                    field.set(job, cell.getStringCellValue());
                    break;
                default:
                    break;
            }
        }
        cell.setCellType(CellType.STRING);
        if (!isEmpty && (cell.getCellTypeEnum().equals(CellType.BLANK) || StringUtils.isEmpty(cell.getStringCellValue()))) {
            throw new Exception(indexColumn + "-不能为空");
        }
    }

    /**
     * 将Sheet列号变为列名
     *
     * @param row  行, 从0开始
     * @param cell 列, 从0开始
     * @return 0->A; 1->B...26->AA
     * 根据表元的列名转换为列号
     */
    private static String getIndexColumn(Row row, Cell cell) {
        int rowNo = row.getRowNum();
        int index = cell.getColumnIndex();
        if (index < 0) {
            return null;
        }
        int num = 65;// A的Unicode码
        String colName = "";
        do {
            if (colName.length() > 0) {
                index--;
            }
            int remainder = index % 26;
            colName = ((char) (remainder + num)) + colName;
            index = (int) ((index - remainder) / 26);
        } while (index > 0);
        return colName + "" + rowNo;
    }

    /***
     *导出文件
     * @param clazz
     */
    public static <T extends Object> Workbook exportExcel(Class<T> clazz, String sheetName, List<T> objectList) throws Exception {
        Workbook workbook = new HSSFWorkbook();
        T job = null;
        Sheet sheet = workbook.createSheet(sheetName);
        Row row = sheet.createRow(0);
        job = clazz.newInstance();
        ExcelAnnotation excelAnnotation = null;
        CellStyle style = null;
        Field[] fields = job.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ExcelAnnotation.class)) {
                // 对象的属性的访问权限设置为可访问
                field.setAccessible(true);
                excelAnnotation = field.getAnnotation(ExcelAnnotation.class);
                int column = excelAnnotation.column();
                boolean isRow = excelAnnotation.isRow();
                if (isRow) {
                    break;
                }
                String name = excelAnnotation.name();
                Cell cell = row.createCell(column);
                style = PoiUtils.setFormat(workbook, cell);
                style.setFillForegroundColor(IndexedColors.AUTOMATIC.getIndex());
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell.setCellValue(name);
            }
        }
        for (int i = 0; i < objectList.size(); i++) {
            job = objectList.get(i);
            row = sheet.createRow(i + 1);
            fields = job.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(ExcelAnnotation.class)) {
                    // 对象的属性的访问权限设置为可访问
                    field.setAccessible(true);
                    excelAnnotation = field.getAnnotation(ExcelAnnotation.class);
                    boolean isRow = excelAnnotation.isRow();
                    if (isRow) {
                        break;
                    }
                    int column = excelAnnotation.column();
                    Cell cell = row.createCell(column);
                    cell.setCellValue(field.get(job).toString());
                }
            }
        }
        return workbook;
    }


    /***
     *
     * @param workbook
     * @param cell
     * @return
     */
    public static CellStyle setFormat(Workbook workbook, Cell cell) {
        CellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setAlignment(HorizontalAlignment.CENTER);//水平居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中

        // 背景色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.YELLOW.index);
        //style.setFillBackgroundColor(HSSFColor.);

// 设置边框
        style.setBorderBottom(BorderStyle.THIN);//下边框
        style.setBorderLeft(BorderStyle.THIN);//左边框
        style.setBorderRight(BorderStyle.THIN);//右边框
        style.setBorderTop(BorderStyle.THIN); //上边框
// 自动换行
        style.setWrapText(true);

// 生成一个字体
        Font font = workbook.createFont();
        font.setFontName("华文行楷");//设置字体名称
        font.setFontHeightInPoints((short) 12);//设置字号
        font.setItalic(false);//设置是否为斜体
        font.setBold(true);//设置是否加粗
        font.setColor(IndexedColors.BLACK.index);//设置字体颜色
        style.setFont(font);

// 把字体 应用到当前样式
        style.setFont(font);

//style设置好后，为cell设置样式
        cell.setCellStyle(style);//cell为已有的单元格
        return style;
    }
}
