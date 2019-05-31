package com.sam.testdemo.test20190314;

import java.io.File;
import java.io.IOException;

/**
 * isDirectory() 检查一个对象是否是文件夹
 * mkdir() 只创建最后一个文件夹。父文件夹必须存在才能创建成功。
 * mkdirs() 无论父文件夹是否存在，都会创建。
 *
 * list() 获取该目录下的所有文件
 * listFiles() 是获取该目录下所有文件和目录的绝对路径
 * @author Administrator
 */
public class FileTest {

    public static void main(String[] args) {

        // 文件操作
        File file = new File("D:\\testData.txt");
        if (file.exists()) {
            // 文件绝对路径
            System.out.println(file.getAbsolutePath());
            // 得到文件大小
            System.out.println("文件大小：" + file.length());
        }

        // 创建文件
        File file1 = new File("d:\\iotest.txt");
        if (!file1.exists()) {
            try {
                // 创建新文件
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已存在");
        }

        // 创建文件夹
        File file2 = new File("d:\\testIO");
        // 检查一个对象是否是文件夹
        if (file2.isDirectory()) {
            System.out.println("文件夹已存在");
        } else {
            file2.mkdir();
            // file2.mkdirs();
        }

        // 列出一个文件夹下的所有文件
        File file3 = new File("d:\\testIO");
        if (file3.isDirectory()) {
            File lists[] = file3.listFiles();
            for (int i = 0; i < lists.length; i++) {
                System.out.println(lists[i].getName());
            }
        }

    }
}
