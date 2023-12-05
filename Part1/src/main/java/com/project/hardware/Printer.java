package com.project.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("print")
public class Printer implements Hardware {

    public String id;
    public String name;
    public String type;

    public Printer(){}

    @Autowired
    public void setId(@Value("${printer.id}") String id) {
        this.id = id;
    }

    @Autowired
    public void setName(@Value("${printer.name}") String name) {
        this.name = name;
    }

    @Autowired
    public void setType(@Value("${printer.type}") String type) {
        this.type = type;
    }

    @Override
    public void use(String document) {
        System.out.println("Printing a " + document + " document");
    }

    @Override
    public String toString() {
        return "Printer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
