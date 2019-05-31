package com.sam.testdemo.feb_tx;

import com.sam.testdemo.feb_tx.inherit.Ball;
import com.sam.testdemo.feb_tx.inherit.Person;

import java.util.Date;
import java.util.Scanner;

public class Test {

    // 函数多个相同名字的，但是参数个数和类型不能一样的称之为函数重载
    public Test(int intNum, String str) {

    }

    // 名称相同，参数个数和类型不同
    public Test(int intNum, String str, double nums) {

    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        Person person = new Person();
        System.out.println(person.toString());

        // 类的继承关系
        Scanner reader = new Scanner(System.in);
        Ball ball = new Ball();
        double r;
        System.out.println("请输入圆的半径：");
        r = reader.nextDouble();
        ball.setR(r);
        System.out.println("体积：" + ball.getValumn());


        // Date底层是 long类型的值
        Date data = new Date();

        // String 底层是char[]
        String name = "keke";

        // 这些操作是在栈里进行的
        int d = sum(1, 2);
        System.out.println(d);

        // 调用者传递的数据需要与函数声明的参数类型是匹配的，但不要求完全一样
        // Java编译器会自动进行类型转换，并寻找最匹配的函数
        char a = 'a';
        char b = 'b';
        // 感觉是特例，实际开发中必须按照对应的类型传入参数类型(也是规范所致)
        System.out.println(Math.max(a, b));
    }
}
