package com.project.entity;

public class Person {

    // instantiate using factory method
    public static Person getInstance(){
        System.out.println("using method factory getInstanceto instantiate");
        return new Person();
    }

    public static Person getInstance(String name, int age, String gender){
        System.out.println("using method factory getInstance to instantiate");
        return new Person(name, age, gender);
    }

    private String name;
    private int age;
    private String gender;

    // default instantiate
    public Person() {
    }

    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void init(){
        System.out.println("Initialize a person with name : "+ name + ", age : " + age + ", gender : " + gender);
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
