package com.sam.testdemo.test20190316;


import java.io.*;

/**
 * FileReader
 *
 * @author Administrator
 */
public class FileReaderTest {

    public static void main(String[] args) {

        File file = new File("D:/testIO/vuetest.html");
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }

        try (
//                FileInputStream in = new FileInputStream(file);
//                InputStreamReader isr = new InputStreamReader(in, "UTF-8");
                // 这一行就可以替代上两行 继承了InputStreamReader
                FileReader fr = new FileReader(file);
        ) {

            char[] cr = new char[1024];
            int len = 0;
            while ((len = fr.read(cr)) != -1) {
                System.out.println(new String(cr, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
