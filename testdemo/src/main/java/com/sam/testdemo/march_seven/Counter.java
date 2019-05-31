package com.sam.testdemo.march_seven;

/**
 * synchronized
 * 多个线程并发更新同一个Counter对象的时候不会出现问题
 *
 * @author Administrator
 */
public class Counter {

    private int count;

    public synchronized void incr() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }

}
