package com.sam.testdemo.test20190314;

import java.io.*;

/**
 * File 操作
 *
 * @author Administrator
 */
public class IOTest {

    public static void main(String[] args) {

        // 读取文件内容
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:/testIO/testData.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
