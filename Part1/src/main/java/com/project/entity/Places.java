package com.project.entity;

import java.util.Map;

public class Places {

    private Map points;

    public Map getPoints() {
        return points;
    }

    public void setPoints(Map points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Places{" +
                "points=" + points +
                '}';
    }
}
