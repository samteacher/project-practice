package com.sam.testdemo.march_seven;


import java.io.Serializable;

/**
 * @author Administrator
 */
public class Student implements Serializable {

    private String name;

    private Integer age;

    private double scope;

    public Student(String name, Integer age, double scope) {
        this.name = name;
        this.age = age;
        this.scope = scope;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getScope() {
        return scope;
    }

    public void setScope(double scope) {
        this.scope = scope;
    }
}
