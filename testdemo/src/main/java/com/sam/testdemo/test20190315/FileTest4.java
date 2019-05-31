package com.sam.testdemo.test20190315;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * list() 获取该目录下的所有文件
 * listFiles() 是获取该目录下所有文件和目录的绝对路径
 *
 * @author Administrator
 */
public class FileTest4 {

    public static void main(String[] args) {

        File directory = new File("D://Go");

//        String[] files = directory.list();
//        for (int i = 0; i < files.length; i++) {
//            System.out.println(files[i]);
//        }

//        File[] files1 = directory.listFiles();
//        for (File file : files1) {
//            System.out.println(file.getAbsolutePath());
//        }

        List<File> list = listFiles(new ArrayList<>(), directory);
        for (File file : list) {
            System.out.println("获取子目录：" + file);
        }
    }

    /**
     * 递归获取子目录下文件
     *
     * @param files
     * @param directory
     * @return
     */
    public static List<File> listFiles(List<File> files, File directory) {
        File[] files2 = directory.listFiles();
        for (File file : files2) {
            if (file.isFile()) {
                files.add(file);
            }
            if (file.isDirectory()) {
                listFiles(files, file);
            }
        }
        return files;
    }

}
