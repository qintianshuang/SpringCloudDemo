package com.example.cloud.service.date;

import com.example.cloud.service.config.LogUtils;

import java.io.File;

public class LoggerTest {

    private static final String TAG = "Main";

    public static void main(String[] args) throws Exception {
        // (可选) 设置日志输出级别, 默认为 INFO 级别
        LogUtils.setLogOutLevel(LogUtils.Level.DEBUG);

        // (可选) 设置日志输出文件(追加到文件尾部)
        LogUtils.setLogOutFile(new File("MyLog.log"));

        // (可选) 设置日志输出位置(是否输出到控制台 和 是否输出到文件), 默认只输出到控制台, 不输出到文件
        LogUtils.setLogOutTarget(true, true);

        // 输出日志
        LogUtils.debug(TAG, "The debug log.");
        LogUtils.info(TAG, "The info log.");
        LogUtils.warn(TAG, "The warn log.");
        LogUtils.error(TAG, "The error log.");
    }
}
