package com.sam.testdemo.test20190314;

/**
 * 引用类型：强引用、软引用、弱引用和虚引用
 * 强引用类型
 * 特点：
 * 1)强引用可以直接访问目标对象（内存地址-堆）
 * 2)强引用所指向的对象在任何时候都不会系统回收。JVM抛出OOM异常（内存溢出），也不回收强引用所指向的对象
 * 3)强引用可以导致内存泄漏
 *
 * @author Administrator
 */
public class StringBufferTest {

    public static void main(String[] args) {

        // 以下两个引用都是强引用
        StringBuffer str = new StringBuffer("Hello world");
        StringBuffer str1 = str;
        System.out.println(str == str1);
        System.out.println(str.equals(str1));
    }
}
