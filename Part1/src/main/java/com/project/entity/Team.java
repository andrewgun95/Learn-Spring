package com.project.entity;

import java.util.List;

public class Team {

    // private List<Person> member;
    // * not specific for given type to make list more general can be receive any type
    private List member; // or Object[] member

    public Team(){}

    public List getMember() {
        return member;
    }

    public void setMember(List member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Team{" +
                "member=" + member +
                '}';
    }
}
