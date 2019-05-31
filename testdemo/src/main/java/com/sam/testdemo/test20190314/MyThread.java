package com.sam.testdemo.test20190314;

/**
 * 线程池测试
 */
public class MyThread implements Runnable {

    protected String name;

    public MyThread(){

    }

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        for (int i = 0; i < 1000; i++) {
//            new Thread(new MyThread("testNoThreadPool" + Integer.toString(i))).start();
//        }

        for (int i = 0; i < 1000; i++) {
            ThreadPool.getInstance().start(new MyThread("testNoThreadPool" + Integer.toString(i)));
        }
    }
}
