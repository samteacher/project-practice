package com.sam.testdemo.test20190314;

/**
 * 线程池
 *
 * @author Administrator
 */
public class PThread extends Thread {

    // 线程池
    private ThreadPool pool;
    // 任务
    private Runnable target;
    private boolean isShutDown = false;
    private boolean isTdle = false;

    // 构造函数
    public PThread(Runnable target, String name, ThreadPool pool) {
        super(name);
        this.pool = pool;
        this.target = target;
    }

    public Runnable getTarget() {
        return target;
    }

    public boolean isTdle() {
        return isTdle;
    }

    @Override
    public void run() {
        while (!isShutDown) {
            isTdle = false;
            if (target != null) {
                // 运行任务
                target.run();
            }
            isTdle = true;
            try {
                pool.repool(this);
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException ie) {

            }
            isTdle = false;
        }
    }

    public synchronized void setTarget(java.lang.Runnable newTarget) {
        target = newTarget;
        // 设置任务之后，通知run方法，开始执行这个任务
        notifyAll();
    }

    // 关闭线程
    public synchronized void shutDown() {
        isShutDown = true;
        notifyAll();
    }
}
