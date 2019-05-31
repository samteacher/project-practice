package com.sam.testdemo.test20190318;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * LinkedList
 *
 * @author Administrator
 */
public class ListDemo2 {

    public static void main(String[] args) {

        // PriorityQueue 单向队列
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(-3);
        queue.offer(1);
        queue.offer(88);
        queue.offer(77);
        queue.offer(-8);

        // 获取队列头元素，不删除队列元素
        System.out.println(queue.peek());

        // 获取队列头元素，删除队列元素
        System.out.println(queue.poll());

        // 删除队列中指定的元素
        System.out.println(queue.remove(88));

        // 添加元素 add offer 推荐使用offer
        for (Integer ints : queue) {
            // 默认排序 大——小
            System.out.println(ints);
        }


        // 双向链表
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

//        System.out.println(integers.get(1));
//        integers.peek();
//        integers.poll();


        // 双向的队列
        // Queue 先进先出
        // 栈 先进后出
//        Queue<Integer> queue = new ArrayDeque<>();


    }
}

