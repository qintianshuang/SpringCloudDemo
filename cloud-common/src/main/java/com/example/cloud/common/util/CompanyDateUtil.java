package com.example.cloud.common.util;

import com.example.cloud.common.config.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CompanyDateUtil {

    private final static Logger log = Logger.getLogger(CompanyDateUtil.class);

    public static String getLastDayOfMonth(String dateStr, String informat, String outformat) {
        String lastDateStr = "";
        DateFormat indf = new SimpleDateFormat(informat);
        SimpleDateFormat outdf = new SimpleDateFormat(outformat);

        try {
            Date date = indf.parse(dateStr);
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            ca.set(5, 1);
            ca.add(2, 1);
            ca.add(5, -1);
            Date lastDate = ca.getTime();
            lastDateStr = outdf.format(lastDate);
        } catch (ParseException var9) {
            log.error(var9.getMessage(), var9);
        }
        log.info("当前所在月最后一天(公司的方法)为【" + lastDateStr + "】");
        return lastDateStr;
    }
}
