package com.sam.testdemo.feb_tx.inherit2;

public class Child extends Base {

    public static int s;
    private int a;

    static {
        System.out.println("基类静态代码块s：" + s);
        s = 10;
    }

    {
        System.out.println("基类实例代码块a：" + a);
        a = 10;
    }

    public Child() {
        System.out.println("基类构造方法，a：" + a);
        a = 20;
    }

    @Override
    protected void step() {
        System.out.println("child s：" + s + ",a：" + a);
    }

}
