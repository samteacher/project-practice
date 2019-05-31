package com.sam.testdemo.test20190314;

import java.util.List;
import java.util.Vector;

/**
 * 线程池
 *
 * @author Administrator
 */
public class ThreadPool {

    private static ThreadPool instance = null;

    private List<PThread> idleThreads;

    private int threadCounter;
    private boolean isShutDown = false;

    private ThreadPool() {
        this.idleThreads = new Vector<>(5);
        threadCounter = 0;
    }

    public int getCreatedThreadsCount() {
        return threadCounter;
    }

    public synchronized static ThreadPool getInstance() {
        if (instance == null) {
            instance = new ThreadPool();
        }
        return instance;
    }

    // 停止池中所有线程
    public synchronized void shutdown() {
        isShutDown = true;
        for (int threadIndex = 0; threadIndex < idleThreads.size(); threadIndex++) {
            PThread idleThread = (PThread) idleThreads.get(threadIndex);
            idleThread.shutDown();
        }
    }

    public synchronized void start(Runnable target) {
        PThread thread = null;
        if (idleThreads.size() > 0) {
            int lastIndex = idleThreads.size() - 1;
            thread = (PThread) idleThreads.get(lastIndex);
            // 立即执行这个任务
            thread.setTarget(target);
            // 没有空闲线程，则创建新线程
        } else {
            threadCounter++;
            // 创建新线程
            thread = new PThread(target, "PThread # " + threadCounter, this);
            // 启动这个线程
            thread.start();
        }
    }

    public void repool(PThread pThread) {
    }
}
