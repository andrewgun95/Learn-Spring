package com.project.entity;

public class Family {

    private Person husband;
    private Person wife;

    private Region region;

    public Family() {
    }

    public Family(Person husband, Person wife) {
        this.husband = husband;
        this.wife = wife;
    }

    public void init() {
        System.out.println("Initialize " + husband.getName() + " family");
    }

    public Person getHusband() {
        return husband;
    }

    public void setHusband(Person husband) {
        this.husband = husband;
    }

    public Person getWife() {
        return wife;
    }

    public void setWife(Person wife) {
        this.wife = wife;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Family{" +
                "husband=" + husband +
                ", wife=" + wife +
                ", region=" + region +
                '}';
    }
}
