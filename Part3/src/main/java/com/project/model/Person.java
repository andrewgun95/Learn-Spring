package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {

    private String name;
    private String email;
    private int age;

    public String getName() {
        return name;
    }

    @Autowired
    public void setName(@Value("andrew") String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    @Autowired
    public void setEmail(@Value("andrew.gun@gmail.com") String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    @Autowired
    public void setAge(@Value("23") int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
