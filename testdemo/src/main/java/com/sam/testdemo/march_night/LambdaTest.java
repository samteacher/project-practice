package com.sam.testdemo.march_night;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Lambda表达式
 *
 * @author Administrator
 */
public class LambdaTest {

    public static void main(String[] args) {

        /**
         *   -> 箭头表达式
         */


        File f = new File(".");
        File[] files = f.listFiles(new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                if(name.endsWith(".txt")){
                    return true;
                }
                return false;
            }
        });

        // 简化后代码
//        File[] files = f.listFiles((File dir, String name) -> {
//            if (name.endsWith(".txt")) {
//                return true;
//            }
//            return false;
//        });

        // 简化后代码
        File[] files2 = f.listFiles((File dir, String name) -> {
            return name.endsWith(".txt");
        });

        File[] files3 = f.listFiles((File dir, String name) -> name.endsWith(".txt"));
    }
}
