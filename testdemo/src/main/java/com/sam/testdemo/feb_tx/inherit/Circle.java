package com.sam.testdemo.feb_tx.inherit;

/**
 * @author Administrator
 */
public class Circle {

    /**
     * 半径
     */
    protected double r;

    public Circle() {
        super();
    }

    public void setR(double r) {
        this.r = r;
    }

    /**
     * 获取圆的面积
     *
     * @return
     */
    public double getArea() {
        return 3.14 * r * r;
    }

}
