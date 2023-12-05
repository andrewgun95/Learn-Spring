package com.project.entity;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// Triangle class can access application context (refer to same instance application context in main)
// Triangle class can access bean name in .xml configuration
public class Triangle implements Shape, ApplicationContextAware, BeanNameAware {

    // DEPENDENCY INJECTION

    // * Triangle have name, type, size dependent
    // * and all this dependency values injected by other environment (spring container)
    // * using setter

    private String name;
    private String type;
    private int size;

    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public void draw() {
        System.out.println("Draw a triangle " + getType());
        System.out.println("Point A : ( " + pointA.getX() + " , " + pointA.getY() + " )");
        System.out.println("Point B : ( " + pointB.getX() + " , " + pointB.getY() + " )");
        System.out.println("Point C : ( " + pointC.getX() + " , " + pointC.getY() + " )");
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                '}';
    }

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    // What the advantage access application context ?
    // There are some feature in application context, maybe we will use inside class bean definition

    public void setBeanName(String beanName) {
        System.out.println(beanName);
    }

    // get points bean object with prototype bean scope
    public Point getProtoPointA() {
        return (Point) applicationContext.getBean(pointA.getName());
    }

    public Point getProtoPointB() {
        return (Point) applicationContext.getBean(pointB.getName());
    }

    public Point getProtoPointC() {
        return (Point) applicationContext.getBean(pointC.getName());
    }

}
