package com.sam.testdemo.feb_tx.inherit2;

public class MainTest {

    public static void main(String[] args) {

        /**
         * 继承可能破坏封装是因为子类和父类之间可能存在着实现细节的依赖
         */
        System.out.println("new child");
        Child child = new Child();

        System.out.println("child.action()");
        child.action();

        Base base = child;
        System.out.println("base.action()");
        base.action();

    }
}
