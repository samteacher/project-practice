package com.sam.testdemo.test20190316;

import java.io.*;

/**
 * BufferedReader
 *
 * @author Administrator
 */
public class BufferReaderTest {

    public static void main(String[] args) {

        File file = new File("D:/testIO/vuetest.html");
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }

        try (
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                // 缓冲流
                BufferedReader buffer = new BufferedReader(isr);
        ) {
            String line = null;
            while ((line = buffer.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
