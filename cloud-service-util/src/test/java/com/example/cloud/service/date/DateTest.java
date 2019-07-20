package com.example.cloud.service.date;

import com.example.cloud.service.util.DateUtils;
import org.junit.Test;

import java.util.Date;

public class DateTest {



    @Test
    public void dateTestOne(){

        Date date = new Date();

//        //获得默认的 date type
//        String datePattern = DateUtils.getDateType();
//        System.out.println("获得默认的 date type:" + datePattern);
//
//        //根据预设格式返回当前日期
//        String now = DateUtils.getNow();
//        System.out.println("根据预设格式返回当前日期:" + now);
//
//        //根据用户格式返回当前日期
//        String yyyyMMddHHmmssS1 = DateUtils.getNow("yyyyMMddHHmmssS");
//        System.out.println("根据用户格式返回当前日期:" + yyyyMMddHHmmssS1);
//
//        //使用预设格式格式化日期
//        String format = DateUtils.format(date);
//        System.out.println("使用预设格式格式化日期:" + format);
//
//        //使用用户格式格式化日期
//        String yyyyMMddHHmmssS = DateUtils.format(date, "yyyyMMddHHmmssS");
//        System.out.println("使用用户格式格式化日期:" + yyyyMMddHHmmssS);
//
//        //使用用户格式提取字符串日期
//        Date yyyyMMddHHmmssS2 = DateUtils.parse("2019070721240132", "yyyyMMddHHmmssS");
//        System.out.println("使用用户格式提取字符串日期:" + yyyyMMddHHmmssS2);
//
//        //在日期上增加数个整月
//        Date date2 = DateUtils.addMonthToDate(new Date(), 2);
//        String format1 = DateUtils.format(date2);
//        System.out.println("在日期上增加数个整月:" + format1);
//
//        //在日期上增加天数
//        Date date1 = DateUtils.addDayToDate(date, 5);
//        String format2 = DateUtils.format(date1);
//        System.out.println("在日期上增加天数:" + format2);
//
//        //使用用户格式在日期上增加天数
//        String s = DateUtils.addDayToStr(date, 6, "yyyyMMddHHmmssS");
//        System.out.println("使用用户格式在日期上增加天数" + s);
//
//        //获取时间戳
//        String timeString = DateUtils.getTimeString("yyyyMMddHHmmssS");
//        System.out.println("获取时间戳" + timeString);
//
//        //获取当前日期年份
//        String year = DateUtils.getYearNow(date);
//        System.out.println("获取当前日期年份" + year);
//
//        //获取当前日期年份月份
//        String yearAndMonth = DateUtils.getYearAndMonthNow(date);
//        System.out.println("获取当前日期年份月份||" + yearAndMonth);
//
//
//
//        //按用户格式字符串距离今天的天数
//        int i = DateUtils.countDaysToNow("20190702212401", "yyyyMMddHHmmss");
//        System.out.println("按默认格式的字符串距离今天的天数" + i);
//
//        //按用户格式字符串距离今天的天数
//        int j = DateUtils.countDaysToNow(DateUtils.addDayToDate(date, 1));
//        System.out.println("按默认格式的字符串距离今天的天数Date||==========" +j);

        System.out.println();
        System.out.println();
        //获取指定日期的下个月第一天
        String yyyyMMddHHmmss = DateUtils.getNextMonthToFristDay("2019-07-07 08:10:50", "yyyy-MM-dd HH:mm:ss");
        System.out.println("获取指定日期的下个月第一天" + yyyyMMddHHmmss);

        String nextMonthToFristDay = DateUtils.getNextMonthToFristDay(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("获取指定日期Date的下个月第一天||====" + yyyyMMddHHmmss);

        System.out.println();
        System.out.println();

        //获取指定日期的下个月最后一天
        String nextMonthToLastDay = DateUtils.getNextMonthToLastDay("2019-07-07 23:48:00", "yyyy-MM-dd HH:mm:ss");
        System.out.println("获取指定日期的下个月最后一天" + nextMonthToLastDay);

        //获取指定日期的下个月最后一天
        String nextMonthToLastDay1 = DateUtils.getNextMonthToLastDay(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("获取指定日期Date的下个月最后一天||====" + nextMonthToLastDay1);

        System.out.println();
        System.out.println();

        //获取指定日期的上个月第一天
        String lastMonthToFristDay = DateUtils.getLastMonthToFristDay("2019-07-07 08:10:50", "yyyy-MM-dd HH:mm:ss");
        System.out.println("获取指定日期的上个月第一天" + lastMonthToFristDay);

        //获取指定日期的上个月第一天
        String nextMonthToFristDay1 = DateUtils.getLastMonthToFristDay(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("获取指定日期Date的上个月第一天||====" + nextMonthToFristDay1);

        System.out.println();
        System.out.println();

        //获取指定日期的上个月最后一天
        String lastMonthToLastDay = DateUtils.getLastMonthToLastDay("2019-07-07 08:10:50", "yyyy-MM-dd HH:mm:ss");
        System.out.println("获取指定日期的上个月最后一天" + lastMonthToLastDay);

        //获取指定日期的上个月第一天
        String lastMonthToLastDay1 = DateUtils.getLastMonthToLastDay(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("获取指定日期Date的上个月最后一天||====" + lastMonthToLastDay1);

        System.out.println();
        System.out.println();

//        //获取指定时间与当前时间的差
//        long mss = DateUtils.getTimePkNowToMillis("2019-07-07 23:48:00", "yyyy-MM-dd HH:mm:ss");
//        long days = mss / (1000 * 60 * 60 * 24);
//        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
//        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
//        long seconds = (mss % (1000 * 60)) / 1000;
//        String s1 = days + " days " + hours + " hours " + minutes + " minutes "
//                + seconds + " seconds ";
//        System.out.println("获取指定时间与当前时间的差" + s1);
//
//        Date date3 = new Date();
////        try {
////            Thread.sleep(5000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        long timePkNowToMillis = DateUtils.getTimePkNowToMillis(date3);
//        days = timePkNowToMillis / (1000 * 60 * 60 * 24);
//        hours = (timePkNowToMillis % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
//       minutes = (timePkNowToMillis % (1000 * 60 * 60)) / (1000 * 60);
//        seconds = (timePkNowToMillis % (1000 * 60)) / 1000;
//        String s11 = days + " days " + hours + " hours " + minutes + " minutes "
//                + seconds + " seconds ";
//        System.out.println("获取指定时间Date与当前时间的差=====" + s11);
//
//
//
//        //转化为没有符号的字符串时间
//        String s2 = DateUtils.getformatSubStr(new Date(), "yyyy-MM-dd",6);
//        System.out.println("转化为没有符号的字符串时间" + s2);
//
//        //转化为没有符号的字符串时间
//        String s3 = DateUtils.getformatSubStr("2019-07-07 23:48:00", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd",9);
//        System.out.println("转化为没有符号的字符串时间||" + s3);
    }
}
