package com.sam.testdemo.test20190318;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Set集合
 * java8对集合提供了一个Stream操作集合
 *
 * @author Administrator
 */
public class StreamDemo {

    public static void main(String[] args) {

        Set<Integer> nums = new HashSet<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        nums.add(50);

        // Stream  BaseStream（基类）
        IntStream intStream = IntStream.builder()
                .add(28)
                .add(17)
                .add(54)
                .build();

//        System.out.println("找到intStream中最小值：" + intStream.min().getAsInt());

//        System.out.println("找到intStream中最大值：" + intStream.max().getAsInt());

//        System.out.println("intStream总和：" + intStream.sum());

//        System.out.println("intStream数值个数：" + intStream.count());

        System.out.println("IntStream平均数：" + intStream.average().getAsDouble());
    }
}
