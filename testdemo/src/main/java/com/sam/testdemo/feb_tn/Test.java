package com.sam.testdemo.feb_tn;

public class Test {

    // 之前我们一直在说，程序主要就是数据以及对数据的操作，而为了方便操作数据，
    // 高级语言引入了数据类型的概念，Java定义了八种基本数据类型，而类相当于是自定义数据类型，
    // 通过类的组合和继承可以表示和操作各种事物或者说对象

    // 类型并不重要，重要的是能力
    // 那如何表示能力呢？
    //Java使用接口这个概念来表示能力

    // 接口也可以继承，一个接口可以继承别的接口
    // 继承的基本概念与类一样，但与类不同，接口可以有多个父接口


    public static void main(String[] args) {

        // 枚举
        EnumClass size = EnumClass.MEDIUM;
        System.out.println(size);
        // 返回字面值
        System.out.println(size.toString());
        // 判断是否类型个数相同
        System.out.println(size == EnumClass.MEDIUM);
        System.out.println(size.equals(EnumClass.MEDIUM));
        System.out.println(size == EnumClass.MEDIUM);

        // 调用接口
        System.out.println(MyComparable.a);
    }

}
