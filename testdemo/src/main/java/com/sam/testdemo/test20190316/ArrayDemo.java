package com.sam.testdemo.test20190316;


import java.util.Arrays;

/**
 * 数组
 *
 * @author Administrator
 */
public class ArrayDemo {

    public static void main(String[] args) {

        /**
         * 数组 ：缺点：长度固定，不能动态添加元素和删除元素
         * 只能通过索引改有元素的值
         */

        Integer[] intas = {12, 22, 13, 12, 98, 72, 34, 56, 9, 11};

        // 排序
        Arrays.sort(intas);

        for (Integer inte : intas) {
            System.out.print(inte + "\t");
        }

        System.out.println("数组长度：" + intas.length);
        Integer[] a = intas.clone();
        for (Integer nums : a) {
            System.out.print(nums+"\t");
        }

        System.out.println(intas == a);
        System.out.println(intas.equals(a));
    }
}
