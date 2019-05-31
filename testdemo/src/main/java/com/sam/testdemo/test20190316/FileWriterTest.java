package com.sam.testdemo.test20190316;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter
 *
 * @author Administrator
 */
public class FileWriterTest {

    public static void main(String[] args) {

        File file = new File("D:/testIO/vuetest.html");
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }

        try (
            FileWriter fw = new FileWriter(file);
        ) {
            String content = "<div>我了个去1111111111111111</div>";
            fw.write(content);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
