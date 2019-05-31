package com.sam.testdemo.test20190314;

/**
 * 无限制线程的缺陷
 * 在实际开发中，线程的数量必须要控制，大量创建线程对系统性能是有害的
 *
 * @author Administrator
 */
public class ThreadTest {

    public static void main(String[] args) {

        // run方法结束后，自动回收该线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        }).start();

    }
}
