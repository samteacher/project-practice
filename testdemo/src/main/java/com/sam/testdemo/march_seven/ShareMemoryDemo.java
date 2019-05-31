package com.sam.testdemo.march_seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 每个线程表示一条单独的执行流，有自己的程序计数器，有自己的栈
 * 但线程之间可以共享内存
 *
 * @author Administrator
 */
public class ShareMemoryDemo {

    private static int shared = 0;

    private static void incrShared() {
        shared ++;
    }

    static class ChildThread extends Thread {
        List<String> list;

        public ChildThread(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            incrShared();
            list.add(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        Thread t1 = new ChildThread(list);
        Thread t2 = new ChildThread(list);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(shared);
        System.out.println(list);
    }

}
