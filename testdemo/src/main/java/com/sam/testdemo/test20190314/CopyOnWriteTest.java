package com.sam.testdemo.test20190314;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList和CopyOnWriteArraySet
 * 与List和ArrayList的区别：
 * 它是线程安全的，可以被多个线程并发访问
 * 它的迭代器不支持修改操作，但也不会抛出ConcurrentModificationException
 * 它以原子方式支持一些复合操作
 *
 * CopyOnWriteArrayList的内部也是一个数组，但这个数组是以原子方式被整体更新的。
 * 每次修改操作，都会新建一个数组，复制原数组的内容到新数组，在新数组上进行需要的修改，
 * 然后以原子方式设置内部的数组引用，这就是写时拷贝
 *
 * CopyOnWriteArrayList内部使用ReentrantLock
 *
 * 保证线程安全的两种思路，一种是锁，使用synchronized或ReentrantLock，
 * 另外一种是循环CAS，写时拷贝体现了保证线程安全的另一种思路
 *
 * @author Administrator
 */
public class CopyOnWriteTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("c");
        list.add("b");
        list.add("a");

        // 查找元素indexOf  先拿到当前数组elements，然后调用另一个indexOf进行查找
        System.out.println(list.indexOf("b"));

        // 底层是 list.sort()
        Collections.sort(list);
        System.out.println(list);

    }
}
