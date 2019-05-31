package com.sam.testdemo.test20190315;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件操作
 *
 * @author Administrator
 */
public class FileTest {

    public static void main(String[] args) {

        // D:\\写法在linux系统中不支持
        File file = new File("D:/testData.txt");
        if (file.exists()) {
            System.out.println("文件名称：" + file.getName());
            System.out.println("文件路径：" + file.getPath());
            System.out.println("文件绝对路径：" + file.getAbsolutePath());
            System.out.println("文件所在目录：" + file.getParent());
            System.out.println("是否是文件：" + file.isFile());
            System.out.println("是否是文件夹：" + file.isDirectory());
            System.out.println("是否是绝对路径：" + file.isAbsolute());
            System.out.println("文件大小：" + file.length());
            System.out.println("文件最后修改时间：" + dateToString(new Date(file.lastModified()), "yyyy-MM-dd HH:mm"));
        } else {
            System.out.println("当前文件不存在");
        }

    }

    /**
     * 日期转换
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        try {
            return new SimpleDateFormat(pattern).format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
