package com.sam.testdemo.feb_tn;

public interface MyComparable {

    // Java使用interface这个关键字来声明接口，修饰符一般都是public。
    // interface后面就是接口的名字MyComparable。
    // 接口定义里面，声明了一个方法compareTo，但没有定义方法体，接口都不实现方法。
    // 接口方法不需要加修饰符，加与不加都是public的，不能是别的修饰符。

    public static final int a = 0;

    int compareTo(Object other);

}
