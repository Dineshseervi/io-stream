package com.learn.io.stream.model;

import java.io.Serializable;

public class Student  implements Serializable {
    private String name;
    private int age;
    private int standard;

    public Student() {
    }

    public Student(String name, int age, int standard) {
        this.name = name;
        this.age = age;
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }
}
