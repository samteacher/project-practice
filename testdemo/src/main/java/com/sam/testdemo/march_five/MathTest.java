package com.sam.testdemo.march_five;

import java.util.Random;

/**
 * @author Administrator
 */
public class MathTest {

    public static void main(String[] args) {

        // 生成一个0到1的随机数，类型为double，包括0但不包括1
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Math.floor(Math.random() * 10));
//        }

//        Random rnd = new Random();
//        // nextInt()产生一个随机的int，可能为正数，也可能为负数
//        System.out.println(rnd.nextInt());
//        System.out.println(rnd.nextInt(100));

        // 随机生成一个long
        // public long nextLong();
//        System.out.println(rnd.nextLong());

        // 随机生成一个boolean
        // public boolean nextBoolean();
//        System.out.println(rnd.nextBoolean());

        // 产生随机字节
        // public void nextBytes(byte[] bytes);
        // ystem.out.println(rnd.nextBytes(['1','2']));

        // 随机产生的字节放入提供的byte数组bytes，字节个数就是bytes的长度。
        // 产生随机浮点数，从0到1，包括0不包括1
//        System.out.println(rnd.nextFloat());
//        System.out.println(rnd.nextDouble());


        // 设置种子
        // 指定种子是为了实现可重复的随机

        // 伪随机数都是基于一个种子数的，然后每需要一个随机数，都是对当前种子进行一些数学运算，得到一个数，基于这个数得到需要的随机数和新的种子。
        Random random = new Random(20190305);
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt(100) + " ");
        }

    }
}
