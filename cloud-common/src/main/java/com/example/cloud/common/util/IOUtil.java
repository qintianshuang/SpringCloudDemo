package com.example.cloud.common.util;

import java.io.*;

public class IOUtil {

    public static byte[] readFromStream(InputStream is) throws IOException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        writeStream(is, bao);
        return bao.toByteArray();
    }
    public static void writeStream(InputStream is, OutputStream os) throws IOException {
        int BUFFER_LEN = 2048;
        byte[] bytes = new byte[BUFFER_LEN];
        BufferedInputStream bis = new BufferedInputStream(is, BUFFER_LEN);
        BufferedOutputStream bos = new BufferedOutputStream(os, BUFFER_LEN);

        int c;
        while((c = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, c);
            bos.flush();
        }
    }
}
