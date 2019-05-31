package com.sam.testdemo.march_seven;

/**
 * synchronized
 * 多个线程并发更新同一个Counter对象的时候不会出现问题
 * <p>
 * <p>
 * <p>
 * 竞态条件(race condition)是指，当多个线程访问和操作同一个对象时，
 * 最终执行结果与执行时序有关，可能正确也可能不正确
 *
 * @author Administrator
 */
public class CounterThread extends Thread {

    /**
     * 这段代码容易理解，有一个共享静态变量counter，
     * 初始值为0，在main方法中创建了1000个线程，每个
     * 线程就是随机睡一会，然后对counter加1，main线程
     * 等待所有线程结束后输出counter的值
     */
    Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException e) {
        }
        counter.incr();
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 100;
        Counter counter = new Counter();
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new CounterThread(counter);
            threads[i].start();
        }
        for (int i = 0; i < num; i++) {
            // join方法让主线程等待子线程结束，join实际上就是调用了wait
            threads[i].join();
        }
        // 不论运行多少次，结果都是正确的100 不使用synchronized，结果不定
        System.out.println(counter.getCount());
    }

}
