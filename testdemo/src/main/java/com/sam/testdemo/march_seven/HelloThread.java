package com.sam.testdemo.march_seven;

/**
 * 线程
 * Thread
 *
 * @author Administrator
 */
public class HelloThread extends Thread {

    /**
     * run()
     * 线程体
     * 执行的起点就是run方法
     * <p>
     * Thread有一个静态方法currentThread，返回当前执行的线程对象
     */
    @Override
    public void run() {
        System.out.println("thread name: " + Thread.currentThread().getName());
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Thread thread = new HelloThread();
        // start 方法会启动新的线程

        // main方法中通过start方法启动线程
        thread.start();
        // main方法中直接调用run方法
        thread.run();
    }

}
