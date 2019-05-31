package com.sam.testdemo.feb_tn;

/**
 * 实现接口
 * 一个类可以实现多个接口，表明类的对象具备多种能力，各个接口之间以逗号分隔
 * <p>
 * 代码复用
 * 降低了耦合，提高了灵活性
 */
public class Point implements MyComparable {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    // 实现接口必须要实现接口中声明的方法
    @Override
    public int compareTo(Object other) {
        if (!(other instanceof Point)) {
            throw new IllegalArgumentException();
        }
        Point otherPoint = (Point) other;
        double delta = distance() - otherPoint.distance();
        if (delta < 0) {
            return -1;
        } else if (delta > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
