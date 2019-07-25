package com.example.cloud.common.util;

import java.util.regex.Pattern;

public class NumberUtil {

    /** 科学计数法regex */
    private static String kxjsfRegex = "^((-?\\d+.?\\d*)[Ee]{1}[-+]?(\\d+))$";

    /** 科学计数法pattern */
    private static Pattern kxjsfPattern = Pattern.compile(kxjsfRegex);

    /**
     * 判断value是不是科学计数法
     *
     * @param value
     * @return
     */
    public static boolean isENnum(String value) {

        if (null == value) {
            return false;
        }
        value = value.trim();
        if (value.length() == 0) {
            return false;
        }

        return kxjsfPattern.matcher(value).matches();
    }

}
