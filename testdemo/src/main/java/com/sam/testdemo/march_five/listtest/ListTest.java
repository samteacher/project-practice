package com.sam.testdemo.march_five.listtest;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * List
 *
 * @author Administrator
 */
public class ListTest {

    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(123);
        intList.add(456);
        System.out.println(intList.get(0));

        ArrayList<String> strList = new ArrayList<String>();
        strList.add("老马");
        strList.add("编程");
//        System.out.println(strList.size());
//        for (int i = 0; i < strList.size(); i++) {
//            System.out.println(strList.get(i));
//        }
//        System.out.println(strList.indexOf("老马"));
//
//        // 是否包含指定元素
//        System.out.println(strList.contains("编程"));
//        System.out.println(strList);
//        // 移除之后
//        System.out.println(strList.remove(0));
//        // 删除指定对象
//        System.out.println(strList.remove("编程"));
//        System.out.println(strList);


        // 删除所有元素
        // public void clear()

        // 修改指定位置的元素内容
        // public E set(int index, E element)
        System.out.println(strList.set(0, "自己"));
        System.out.println(strList);


        // foreach语法背后是怎么实现的呢？其实，编译器会将它转换为类似如下代码：
//        Iterator<Integer> it = intList.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }




    }
}
