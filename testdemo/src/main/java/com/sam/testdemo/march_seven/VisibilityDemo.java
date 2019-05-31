package com.sam.testdemo.march_seven;

/**
 * 多个线程可以共享访问和操作相同的变量，但一个线程对一个共享变量的修改，
 * 另一个线程不一定马上就能看到，甚至永远也看不到
 *
 * @author Administrator
 */
public class VisibilityDemo {

    private static boolean shutdown = false;

    static class HelloThread extends Thread {
        @Override
        public void run() {
            while (!shutdown) {
                // do nothing
            }
            System.out.println("exit hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new HelloThread().start();
        Thread.sleep(1000);
        shutdown = true;
        System.out.println("exit main");
    }

}
