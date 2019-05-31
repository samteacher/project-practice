package com.sam.testdemo.feb_tn;

/**
 * 抽象类
 */
public abstract class AbstractClass {

    private String name;
    private Integer age;

    public AbstractClass() {

    }

    abstract String getStr();

    public abstract String getString();

    public String getValue() {
        return "value";
    }

}
