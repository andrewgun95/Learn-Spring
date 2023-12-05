package com.project.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("scan")
public class Scanner implements Hardware{

    public String id;
    public String name;
    public String type;

    public Scanner(){}

    @Autowired
    public void setId(@Value("${scanner.id}") String id) {
        this.id = id;
    }

    @Autowired
    public void setName(@Value("${scanner.name}") String name) {
        this.name = name;
    }

    @Autowired
    public void setType(@Value("${printer.type}") String type) {
        this.type = type;
    }

    @Override
    public void use(String document) {
        System.out.println("Scanning a " + document + " document");
    }

    @Override
    public String toString() {
        return "Scanner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
