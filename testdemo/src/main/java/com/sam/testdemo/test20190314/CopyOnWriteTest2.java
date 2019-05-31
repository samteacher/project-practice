package com.sam.testdemo.test20190314;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * CopyOnWriteArraySet实现了Set接口，不包含重复元素，使用比较简单
 * 内部是通过CopyOnWriteArrayList实现的
 * <p>
 * CopyOnWriteArraySet内部使用ReentrantLock
 *
 * @author Administrator
 */
public class CopyOnWriteTest2 {

    public static void main(String[] args) {

        // 底层 new CopyOnWriteArrayList<E>()
        CopyOnWriteArraySet set = new CopyOnWriteArraySet();
        set.add("3");
        set.add("3");
        set.add("3");

        /**
         * CopyOnWriteArraySet是基于CopyOnWriteArrayList实现的，所以与HashSet/TreeSet相比，它的性能比较低，不适用于元素个数特别多的集合。
         * 如果元素个数比较多，可以考虑ConcurrentHashMap或ConcurrentSkipListSet
         */
    }
}
