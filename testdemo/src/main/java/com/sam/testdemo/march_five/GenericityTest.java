package com.sam.testdemo.march_five;

import java.util.Random;

/**
 * 泛型测试
 */
public class GenericityTest {

    public static void main(String[] args) {

        // Pair<Integer>，这里Integer就是传递的实际类型参数。
        Pair<Integer> minmax = new Pair<Integer>(1, 100);
        Integer min = minmax.getFirst();
        Integer max = minmax.getSecond();

        System.out.println(min);
        System.out.println(max);


        DynamicArray<Double> arr = new DynamicArray<Double>();
        Random rnd = new Random();
        int size = 1 + rnd.nextInt(100);
        for (int i = 0; i < size; i++) {
            arr.add(Math.random());
        }

        Double d = arr.get(rnd.nextInt(size));
        System.out.println(d);
    }
}
