package com.sam.testdemo.test20190315;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * InputStream 输入流
 * OutStream 输出流
 * <p>
 * 字符流：文件拷贝、粘贴、生成文件
 * 字节流：操作文件内容
 *
 * @author Administrator
 */
public class FileTest5 {

    public static void main(String[] args) {

        // 读取内容
        File file = new File("D:/testIO/vuetest.html");
        FileInputStream fis = null;
        if (file.exists()) {
            try {
                // 获取输入流
                fis = new FileInputStream(file);
                byte b[] = new byte[1024];
                int len = 0;
                while ((len = fis.read(b)) != -1) {
                    System.out.println(new String(b));
                }
            } catch (IOException e) {
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

}
