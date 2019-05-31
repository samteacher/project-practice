package com.sam.testdemo.march_sex;

import java.util.Map;
import java.util.TreeMap;

/**
 * 剖析TreeMap
 * <p>
 * TreeMap的基本用法，与HashMap相比：
 * <p>
 * 相同的是，它们都实现了Map接口，都可以按Map进行操作。
 * <p>
 * 不同的是，迭代时，TreeMap按键有序，为了实现有序，它要求：要么键实现Comparable接口，要么创建TreeMap时传递一个Comparator对象。
 *
 * @author Administrator
 */
public class TreeMapTest {

    public static void main(String[] args) {

        Map<String, String> map = new TreeMap<>();
        map.put("a", "abstract");
        map.put("c", "call");
        map.put("b", "basic");
        map.put("T", "tree");

        // 输出按键排序的
        for (Map.Entry<String, String> kv : map.entrySet()) {
            System.out.println(kv.getKey() + "=" + kv.getValue() + " ");
        }

        /**
         * PriorityQueue 优先级队列
         * PriorityQueue是用堆实现的，堆物理上就是数组，与ArrayList类似，PriorityQueue同样使用动态数组，根据元素个数动态扩展
         * 实现顾Queue,扩展 Collection
         *
         * PriorityQueue特点分析
         * PriorityQueue实现了Queue接口，有优先级，内部是用堆实现的，这决定了它有如下特点：
         *  实现了优先级队列，最先出队的总是优先级最高的，即排序中的第一个。
         *  优先级可以有相同的，内部元素不是完全有序的，如果遍历输出，除了第一个，其他没有特定顺序。
         *  查看头部元素的效率很高，为O(1)，入队、出队效率比较高，为O(log2(N))，构建堆heapify的效率为O(N)。
         *  根据值查找和删除元素的效率比较低，为O(N)。
         *
         *
         */
    }
}
