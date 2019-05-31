package com.sam.testdemo.march_seven;

/**
 * 线程
 * Runnable
 *
 * @author Administrator
 */
public class HelloRunnable implements Runnable {

    /**
     * NEW: 没有调用start的线程状态为NEW
     * <p>
     * TERMINATED: 线程运行结束后状态为TERMINATED
     * <p>
     * RUNNABLE: 调用start后线程在执行run方法且没有阻塞时状态为RUNNABLE，不过，RUNNABLE不代表CPU一定在执行该线程的代码，
     * 可能正在执行也可能在等待操作系统分配时间片，只是它没有在等待其他条件
     * <p>
     * BLOCKED、WAITING、TIMED_WAITING：都表示线程被阻塞了，在等待一些条件，其中的区别我们在后续章节再介绍
     */

    @Override
    public void run() {
        System.out.println("hello");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread helloThread = new Thread(new HelloRunnable());
        helloThread.start();
        // State 线程的状态

        // 调用start后线程在执行run方法且没有阻塞时状态为RUNNABLE，不过，RUNNABLE不代表CPU一定在执行该线程的代码，
        // 可能正在执行也可能在等待操作系统分配时间片，只是它没有在等待其他条件
        System.out.println(helloThread.getState());

        // 返回线程是否活着
        System.out.println(helloThread.isAlive());

        // Thread有一个静态的sleep方法，调用该方法会让当前线程睡眠指定的时间，单位是毫秒
        // 睡眠期间，线程可以被中断，如果被中断，sleep会抛出InterruptedException
        Thread.sleep(1000);

        //Thread还有一个让出CPU的方法  yield()

        // 调用join的线程等待该线程结束
        helloThread.join();

    }
}
