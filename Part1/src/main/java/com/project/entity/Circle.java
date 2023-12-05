package com.project.entity;

public class Circle implements Shape{

    // DEPENDENCY INJECTION

    // * Circle have name, type, and radius dependent
    // * and all this dependency injected by other environment (spring container)
    // * using constructor

    private String name;
    private String type;
    private int radius;

    private Point center;

    public Circle() {
    }

    public Circle(String name, String type, int radius) {
        this.name = name;
        this.type = type;
        this.radius = radius;
    }

    public Circle(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Circle(String name, int radius) {
        this.name = name;
        this.radius = radius;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public void draw() {
        System.out.println("Draw a circle "+getType());
        System.out.println("Point Center : ( " + center.getX() + " , " + center.getY() + " )");
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", radius=" + radius +
                '}';
    }
}
