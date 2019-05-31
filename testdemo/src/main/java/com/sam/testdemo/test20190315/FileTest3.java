package com.sam.testdemo.test20190315;

import java.io.File;

/**
 * 创建文件夹  文件夹操作
 * <p>
 * isDirectory() 检查一个对象是否是文件夹
 * mkdir() 只创建最后一个文件夹。父文件夹必须存在才能创建成功。
 * mkdirs() 无论父文件夹是否存在，都会创建。
 *
 * @author Administrator
 */
public class FileTest3 {

    public static void main(String[] args) {

        File directory = new File("D:/testIO/iotest");

        //目录的创建
        if (!directory.exists()) {
            // 只创建最后一个文件夹。父文件夹必须存在才能创建成功。
            directory.mkdir();

            //无论父文件夹是否存在，都会创建。
//            directory.mkdirs();
        } else {
            System.out.println("已存在");
        }

    }
}
