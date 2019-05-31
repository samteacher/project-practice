package com.sam.testdemo.test20190315;

import java.io.File;
import java.io.FileOutputStream;
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
public class FileTest6 {

    public static void main(String[] args) {

        // 写入内容
        File file = new File("D:/testIO/iotest/abc.txt");
        FileOutputStream fos = null;
        if (file.exists()) {
            try {
                // true 追加内容
                fos = new FileOutputStream(file,true);
                String content = "<div>我了个去1111111111111111</div>";
                fos.write(content.getBytes());

                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
