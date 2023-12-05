package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("house")
public class House {

    private String name;
    private String address;
    private int rooms;
    private int area; // in m ^ 2

    public String getName() {
        return name;
    }

    @Autowired
    public void setName(@Value("family") String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @Autowired
    public void setAddress(@Value("250 Joralemon Street. Brooklyn, NY 11201") String address) {
        this.address = address;
    }

    public int getRooms() {
        return rooms;
    }

    @Autowired
    public void setRooms(@Value("4") int rooms) {
        this.rooms = rooms;
    }

    public int getArea() {
        return area;
    }

    @Autowired
    public void setArea(@Value("1000") int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rooms=" + rooms +
                ", area=" + area +
                '}';
    }
}
