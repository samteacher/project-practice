package com.sam.testdemo.feb_tx.inherit;

/**
 * @author Administrator
 */
public class Ball extends Circle {

    public double getValumn() {
        return getArea() * r * 4 / 3;
    }

    @Override
    public double getArea() {
        return 3.14 * r * r;
    }

    public Ball() {
        super();
    }

}
