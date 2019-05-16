package com.sam.guavademo.test;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;

/**
 * @author Administrator
 */
public class Test {

    public static void main(String[] args) {

        // Joiner 连接器
        Joiner joiner = Joiner.on("-").skipNulls();
        System.out.println(joiner.join("Harry", "redis", "Ron", "Hermione"));

        Integer value1 = null;
        Integer value2 = 10;

        // 创建指定引用的Optional实例，若引用为null则表示缺失
        Optional<Integer> a = Optional.fromNullable(value1);

        // 用一个默认值来替换可能的null
        Optional<Integer> b = Optional.of(value2);
        System.out.println(sum(a, b));
    }

    private static Integer sum(Optional<Integer> a, Optional<Integer> b) {

        //isPresent()  如果Optional包含非null的引用（引用存在），返回true
        System.out.println("First param is present: " + a.isPresent());
        System.out.println("Second param is present: " + b.isPresent());

        // 返回Optional所包含的引用，若引用缺失，返回指定的值
        Integer value1 = a.or(0);
        Integer value2 = b.get();
        return value1 + value2;
    }

}
