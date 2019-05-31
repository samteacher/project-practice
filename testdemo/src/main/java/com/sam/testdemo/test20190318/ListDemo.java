package com.sam.testdemo.test20190318;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * List集合
 * 有序可重
 * 实现原理 -- 动态数组
 *
 * @author Administrator
 */
public class ListDemo {

    public static void main(String[] args) {

        List<String> lists = new ArrayList<>();
        lists.add("A");
        lists.add(null);
        lists.add(null);
        lists.add(null);
        lists.add("B");
        lists.add("C");
        lists.add("D");
        lists.add("E");

        System.out.println("最一个索引值：" + lists.lastIndexOf("E"));
        System.out.println("索引值为:" + lists.indexOf("D"));
        System.out.println("集合个数：" + lists.size());
        System.out.println("数组截取：" + lists.subList(1, 4));
        System.out.println("根据下标获取对应的值：" + lists.get(4));


//        lists.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.hashCode() > o2.hashCode()) {
//                    return -1;
//                } else if (o1.hashCode() < o2.hashCode()) {
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
//        });

    }
}
