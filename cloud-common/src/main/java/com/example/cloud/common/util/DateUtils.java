package com.example.cloud.service.util;

import com.example.cloud.common.config.Logger;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类 默认使用 "yyyy-MM-dd HH:mm:ss" 格式化日期
 */
public final class DateUtils {

    private final static Logger log = Logger.getLogger(DateUtils.class);

    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * 英文全称 如：2010-12-01 23:15:06
     */
    public static String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_YYYY_MM_DD_HH_MM_SS_S = "yyyyMMddHHmmssS";
    /**
     * 中文简写 如：2010年12月01日
     */
    public static String FORMAT_YYYY_MM_DD_CHINA = "yyyy年MM月dd";
    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */
    public static String FORMAT_YYYY_MM_DD_HH_MM_SS_CHINA = "yyyy年MM月dd日  HH时mm分ss秒";
    /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_YYYY_MM_DD_HH_MM_SS_S_CHINA = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    /**
     * 获得默认的 date type
     */
    public static String getDateType() {
        log.info("获得默认的 date type【" + FORMAT_YYYY_MM_DD_HH_MM_SS + "】");
        return FORMAT_YYYY_MM_DD_HH_MM_SS;
    }

    /**
     * 根据预设格式返回当前日期
     * @return
     */
    public static String getNow() {
        String format = format(new Date());
        return format;
    }

    /**
     * 根据用户格式返回当前日期
     * @param format
     * @return
     */
    public static String getNow(String format) {
        String timeStr = format(new Date(), format);
        log.info("根据用户格式返回当前日期字符串【" + timeStr + "】");
        return timeStr;
    }

    /**
     * 使用预设格式格式化日期
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        String timeStr = "";
        if (date != null) {
            timeStr = format(date, getDateType());
        }
        log.info("使用预设格式格式化日期【" + timeStr + "】");
        return timeStr;
    }

    /**
     * 使用用户格式格式化日期
     *
     * @param date     日期
     * @param timeType 日期格式
     * @return
     */
    public static String format(Date date, String timeType) {
        String timeStr = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(timeType);
            timeStr = df.format(date);
        }
        log.info("使用预设格式格式化日期【" + timeStr + "】");
        return (timeStr);
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param format  日期格式
     * @return
     */
    public static Date parse(String strDate, String format) {
        Date parse = null;
        if (!StringUtils.isEmpty(strDate)) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            try {
                parse = df.parse(strDate);
                return parse;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        log.info("使用用户格式提取字符串日期【" + parse + "】");
        return parse;
    }

    /**
     * 在日期上增加数个整月
     *
     * @param date 日期
     * @param n    要增加的月数
     * @return
     */
    public static Date addMonthToDate(Date date, int n) {
        Date time = null;
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, n);
            time = cal.getTime();
        }
        log.info("在日期【" + date + "】上增加数【" + n + "】个整月为【" + time + "】");
        return time;
    }

    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    要增加的天数
     * @return
     */
    public static Date addDayToDate(Date date, int n) {
        Date time = null;
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, n);
            time = cal.getTime();
        }
        log.info("在日期【" + date + "】上增加【" + n + "】个天数为【" + time + "】");
        return time;
    }

    /***
     * 使用用户格式在日期上增加天数
     * @param date  日期
     * @param n  要增加的天数
     * @param format
     * @return
     */
    public static String addDayToStr(Date date, int n, String format) {
        String timeStr = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, n);
            timeStr = df.format(cal.getTime());
        }
        log.info("使用用户格式在日期【" + date + "】上增加【" + n + "】个天数为【" + timeStr + "】");
        return timeStr;
    }

    /**
     * 获取时间戳
     */
    public static String getTimeString(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        String timeStr = df.format(calendar.getTime());
        log.info("使用用户格式获取时间戳【" + timeStr + "】");
        return timeStr;
    }

    /**
     * 获取当前日期年份
     *
     * @param date 日期
     * @return
     */
    public static String getYearNow(Date date) {
        String timeStr = "";
        if (date != null) {
            String format = format(date);
            timeStr = format.substring(0, 4);
        }
        log.info("获取当前日期年份【" + timeStr + "】");
        return timeStr;
    }

    /**
     * 获取当前日期年份月份
     *
     * @param date 日期
     * @return
     */
    public static String getYearAndMonthNow(Date date) {
        String timeStr = "";
        if (date != null) {
            String format = format(date);
            timeStr = format.substring(0, 7);
        }
        log.info("获取当前日期年份月份【" + timeStr + "】");
        return timeStr;
    }

    /**
     * 转化为没有符号的字符串时间
     *
     * @param date 日期
     * @return
     */
    public static String getformatSubStr(Date date, String timeType, int index) {
        String timeStr = "";
        if (date != null) {
            timeStr = format(date, timeType);
            int strLength = getStrToArray(timeStr);
            if (index < strLength) {
                timeStr = timeStr.substring(0, index);
            }
        }
        log.info("转化为没有符号的字符串时间为【" + timeStr + "】");
        return timeStr;
    }

    /**
     * 转化为截取的字符串时间
     *
     * @param dateStr 日期
     * @return
     */
    public static String getformatSubStr(String dateStr, String format, String timeType, int index) {
        String timeStr = "";
        if (!StringUtils.isEmpty(dateStr)) {
            Date parse = parse(dateStr, format);
            timeStr = format(parse, timeType);
            int strLength = getStrToArray(timeStr);
            if (index < strLength) {
                timeStr = timeStr.substring(0, index);
            }
        }
        log.info("转化为截取的字符串时间为【" + timeStr + "】");
        return timeStr;
    }

    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param dateStr 日期字符串
     * @param format  日期格式
     * @return
     */
    public static int countDaysToNow(String dateStr, String format) {
        int time = 0;
        if (StringUtils.isEmpty(dateStr)) {
            long t = Calendar.getInstance().getTime().getTime();
            Calendar c = Calendar.getInstance();
            c.setTime(parse(dateStr, format));
            long t1 = c.getTime().getTime();
            time = (int) (t / 1000 - t1 / 1000) / 3600 / 24;
        }
        log.info("按用户格式字符串距离今天的天数为【" + time + "】");
        return time;
    }

    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param date 日期字符串
     * @return
     */
    public static int countDaysToNow(Date date) {
        int time = 0;
        if (date != null) {
            long t = Calendar.getInstance().getTime().getTime();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            long t1 = c.getTime().getTime();
            time = (int) (t / 1000 - t1 / 1000) / 3600 / 24;
        }
        log.info("按用户格式字符串距离今天的天数为【" + time + "】");
        return time;
    }

    /***
     * 获取指定日期的下个月第一天
     * @param dateStr
     * @param format
     * @return
     */
    public static String getNextMonthToFristDay(String dateStr, String format) {
        String time = "";
        if (!StringUtils.isEmpty(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            try {
                Date date = sdf.parse(dateStr);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.add(Calendar.MONTH, 1);
                //将小时至0
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                //将分钟至0
                calendar.set(Calendar.MINUTE, 0);
                //将秒至0
                calendar.set(Calendar.SECOND, 0);
                //将毫秒至0
                calendar.set(Calendar.MILLISECOND, 0);
                time = sdf.format(calendar.getTime());
                return time;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        log.info("获取指定日期的下个月第一天为【" + time + "】");
        return time;
    }

    /***
     * 获取指定日期的下个月第一天
     * @param date
     * @param format
     * @return
     */
    public static String getNextMonthToFristDay(Date date, String format) {
        String time = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.MONTH, 1);
            //将小时至0
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            //将分钟至0
            calendar.set(Calendar.MINUTE, 0);
            //将秒至0
            calendar.set(Calendar.SECOND, 0);
            //将毫秒至0
            calendar.set(Calendar.MILLISECOND, 0);
            time = sdf.format(calendar.getTime());
        }
        log.info("获取指定日期的下个月第一天为【" + time + "】");
        return time;
    }

    /***
     * 获取指定日期的下个月最后一天
     * @param dateStr
     * @param format
     * @return
     */
    public static String getNextMonthToLastDay(String dateStr, String format) {
        String time = "";
        if (!StringUtils.isEmpty(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            try {
                Date date = sdf.parse(dateStr);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DATE));
                calendar.add(Calendar.MONTH, 1);
                //将小时至0
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                //将分钟至0
                calendar.set(Calendar.MINUTE, 0);
                //将秒至0
                calendar.set(Calendar.SECOND, 0);
                //将毫秒至0
                calendar.set(Calendar.MILLISECOND, 0);
                time = sdf.format(calendar.getTime());
                return time;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        log.info("获取指定日期的下个月最后一天为【" + time + "】");
        return time;
    }

    /***
     * 获取指定日期的下个月最后一天
     * @param date
     * @param format
     * @return
     */
    public static String getNextMonthToLastDay(Date date, String format) {
        String time = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DATE));
            calendar.add(Calendar.MONTH, 1);
            //将小时至0
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            //将分钟至0
            calendar.set(Calendar.MINUTE, 0);
            //将秒至0
            calendar.set(Calendar.SECOND, 0);
            //将毫秒至0
            calendar.set(Calendar.MILLISECOND, 0);
            time = sdf.format(calendar.getTime());
        }
        log.info("获取指定日期的下个月最后一天为【" + time + "】");
        return time;
    }

    /***
     * 获取指定日期的上个月第一天
     * @param dateStr
     * @param format
     * @return
     */
    public static String getLastMonthToFristDay(String dateStr, String format) {
        String time = "";
        if (!StringUtils.isEmpty(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            try {
                Date date = sdf.parse(dateStr);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
                calendar.add(Calendar.MONTH, -1);
                //将小时至0
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                //将分钟至0
                calendar.set(Calendar.MINUTE, 0);
                //将秒至0
                calendar.set(Calendar.SECOND, 0);
                //将毫秒至0
                calendar.set(Calendar.MILLISECOND, 0);
                time = sdf.format(calendar.getTime());
                return time;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        log.info("获取指定日期的上个月第一天为【" + time + "】");
        return time;
    }

    /***
     * 获取指定日期的上个月第一天
     * @param date
     * @param format
     * @return
     */
    public static String getLastMonthToFristDay(Date date, String format) {
        String time = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            calendar.add(Calendar.MONTH, -1);
            //将小时至0
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            //将分钟至0
            calendar.set(Calendar.MINUTE, 0);
            //将秒至0
            calendar.set(Calendar.SECOND, 0);
            //将毫秒至0
            calendar.set(Calendar.MILLISECOND, 0);
            time = sdf.format(calendar.getTime());
        }
        log.info("获取指定日期的上个月第一天为【" + time + "】");
        return time;
    }

    /***
     * 获取指定日期的上个月最后一天
     * @param dateStr
     * @param format
     * @return
     */
    public static String getLastMonthToLastDay(String dateStr, String format) {
        String time = "";
        if (!StringUtils.isEmpty(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            try {
                Date date = sdf.parse(dateStr);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DATE));
                calendar.add(Calendar.MONTH, -1);
                //将小时至0
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                //将分钟至0
                calendar.set(Calendar.MINUTE, 0);
                //将秒至0
                calendar.set(Calendar.SECOND, 0);
                //将毫秒至0
                calendar.set(Calendar.MILLISECOND, 0);
                time = sdf.format(calendar.getTime());
                return time;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        log.info("获取指定日期的上个月最后一天为【" + time + "】");
        return time;
    }


    /***
     * 获取指定日期的上个月最后一天
     * @param date
     * @param format
     * @return
     */
    public static String getLastMonthToLastDay(Date date, String format) {
        String time = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DATE));
            calendar.add(Calendar.MONTH, -1);
            //将小时至0
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            //将分钟至0
            calendar.set(Calendar.MINUTE, 0);
            //将秒至0
            calendar.set(Calendar.SECOND, 0);
            //将毫秒至0
            calendar.set(Calendar.MILLISECOND, 0);
            time = sdf.format(calendar.getTime());
        }
        log.info("获取指定日期的上个月最后一天为【" + time + "】");
        return time;
    }

    /***
     * 获取指定时间指定格式与当前时间的差
     * @param dateStr
     * @param format
     * @return
     */
    public static long getTimePkNowToMillis(String dateStr, String format) {
        long outTime = 0;
        if (!StringUtils.isEmpty(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date parse = null;
            try {
                parse = sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long comTime = parse.getTime();
            Date date = new Date();
            long sysTime = date.getTime();
            outTime = sysTime - comTime;
        }
        log.info("获取指定时间指定格式与当前时间的差为【" + outTime + "】");
        return outTime;
    }

    /***
     * 获取指定时间与当前时间的差
     * @param parse
     * @return
     */
    public static long getTimePkNowToMillis(Date parse) {
        long outTime = 0;
        if (parse != null) {
            long comTime = parse.getTime();
            Date date = new Date();
            long sysTime = date.getTime();
            outTime = sysTime - comTime;
        }
        log.info("获取指定时间与当前时间的差为【" + outTime + "】");
        return outTime;
    }

    /***
     * 获取指定时间与指定时间的差
     * @param dateStrOne
     * @param dateStrTwo
     * @param format
     * @return
     */
    public static long getTimePkNowToMillis(String dateStrOne, String dateStrTwo, String format) {
        long outTime = 0;
        if (!StringUtils.isEmpty(dateStrOne) && !StringUtils.isEmpty(dateStrTwo)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date parseOne = null;
            Date parseTwo = null;
            try {
                parseOne = sdf.parse(dateStrOne);
                parseTwo = sdf.parse(dateStrTwo);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long comTimeOne = parseOne.getTime();
            long comTimeTwo = parseTwo.getTime();
            outTime = comTimeTwo - comTimeOne;
        }
        log.info("获取指定时间与指定时间的差为【" + outTime + "】");
        return outTime;
    }

    /***
     *字符串转化为Byte数组
     * @param str
     * @return
     */
    public static int getStrToArray(String str) {
        int length = 0;
        if (!StringUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes();
            length = bytes.length;
        }
        return length;
    }

    /***
     * 获取当前日期所在月最后一天
     * @param date
     * @param format
     * @return
     */
    public static String getNowToLastDay(Date date, String format) {
        String time = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DATE));
            calendar.add(Calendar.MONTH, 0);
            //将小时至0
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            //将分钟至0
            calendar.set(Calendar.MINUTE, 0);
            //将秒至0
            calendar.set(Calendar.SECOND, 0);
            //将毫秒至0
            calendar.set(Calendar.MILLISECOND, 0);
            time = sdf.format(calendar.getTime());
        }
        log.info("获取当前日期所在月最后一天为【" + time + "】");
        return time;
    }

    public static void main(String[] args) {

    }
}
