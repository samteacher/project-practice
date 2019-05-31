package com.sam.testdemo.test20190315;

import java.lang.String;
import java.io.*;

/**
 * 字符流  以2字节处理 16位
 * Reader
 * Writer
 *
 * @author Administrator
 */
public class CharacterStreamTest {

    public static void main(String[] args) {

        // JDK1.8之后加入了 Closeable  不需要关闭流了
        File file = new File("D:/testIO/vuetest.html");
        if (file.exists()) {
            try (
                    FileInputStream in = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            ) {
                char[] cr = new char[1024];
                int len = 0;
                if ((len = isr.read(cr)) != -1) {
                    System.out.println(new String(cr, 0, len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 读取内容
//        File file = new File("D:/testIO/vuetest.html");
//        FileInputStream in = null;
//        InputStreamReader isr = null;
//        if (file.exists()) {
//            try {
//                // 转换字节流
//                in = new FileInputStream(file);
//                isr = new InputStreamReader(in, "UTF-8");
//
//                char[] cr = new char[1024];
//                int len = 0;
//
//                if ((len = isr.read(cr)) != -1) {
//                    System.out.println(new String(cr, 0, len));
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (isr != null) {
//                        isr.close();
//                    }
//                    if (in != null) {
//                        in.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }
}
