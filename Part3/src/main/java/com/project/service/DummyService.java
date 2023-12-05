package com.project.service;

import com.project.model.House;
import com.project.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dummy")
public class DummyService {

    private Person person;
    private House house;

    public Person getPerson() {
        return person;
    }

    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }

    public House getHouse() {
        return house;
    }

    @Autowired
    public void setHouse(House house){
        this.house = house;
    }

    @Override
    public String toString() {
        return "DummyService{" +
                "person=" + person +
                ", house=" + house +
                '}';
    }
}
