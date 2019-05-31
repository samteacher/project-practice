package com.sam.testdemo.test20190314;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap
 * 特点：
 * 并发安全
 * 直接支持一些原子复合操作
 * 支持高并发、读操作完全并行、写操作支持一定程度的并行
 * 与同步容器Collections.synchronizedMap相比，迭代不用加锁，不会抛出ConcurrentModificationException
 * 弱一致性
 *
 * @author Administrator
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {

        // ConcurrentHashMap 实现了Map接口
        final Map<Integer, Integer> map = new ConcurrentHashMap<>();
    }
}
