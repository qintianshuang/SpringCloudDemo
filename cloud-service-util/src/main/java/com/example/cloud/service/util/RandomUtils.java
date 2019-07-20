package com.example.cloud.service.util;

/***
 * 随机数
 */
public class RandomUtils {

    private static byte[] lock = new byte[0];
    // 位数，默认是8位
    private final static long w = 100000000;

    /***
     * 生成不重复的随机数
     * @return
     */
    public static String randomID(){
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }
        String str = System.currentTimeMillis() + String.valueOf(r).substring(1);
        return str;
    }
}
