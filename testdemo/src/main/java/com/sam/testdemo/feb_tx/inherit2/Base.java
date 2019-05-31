package com.sam.testdemo.feb_tx.inherit2;

public class Base {

    public static int s;
    private int a;

    static {
        System.out.println("基类静态代码块s：" + s);
        s = 1;
    }

    {
        System.out.println("基类实例代码块a：" + a);
        a = 1;
    }

    public Base() {
        System.out.println("基类构造方法，a：" + a);
        a = 2;
    }

    protected void step() {
        System.out.println("base s：" + s + ",a：" + a);
    }

    public void action() {
        System.out.println("start");
        step();
        System.out.println("end");
    }

}
