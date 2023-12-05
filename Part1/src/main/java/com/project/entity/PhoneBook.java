package com.project.entity;

import java.util.List;

public class PhoneBook {

    private List<String> phones;

    public PhoneBook(){}

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phones=" + phones +
                '}';
    }
}
