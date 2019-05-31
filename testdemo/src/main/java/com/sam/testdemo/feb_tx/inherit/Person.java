package com.sam.testdemo.feb_tx.inherit;

public class Person {

    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person() {

    }

    public Person(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    // 重写就是覆盖
    @Override
    public String toString() {
        return "重写Object的toString()方法";
    }

    // 重载
    public String toString(String username) {
        return username + "：重写Object的toString()方法";
    }
}
