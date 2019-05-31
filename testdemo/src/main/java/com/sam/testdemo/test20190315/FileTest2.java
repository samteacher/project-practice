package com.sam.testdemo.test20190315;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件
 *
 * @author Administrator
 */
public class FileTest2 {

    public static void main(String[] args) throws IOException {

        File file = new File("D:/testIO/test1.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("创建成功：" + file.getAbsolutePath());
        } else {
            System.out.println("文件已经存在");
        }

        // 删除文件
        if (file.exists()) {
            //文件打开，或者占用的时候，删不了
            file.delete();

            //注册一个删除钩子，只有java虚拟机退出的时候，才会删除
//            file.deleteOnExit();
        }
    }
}
