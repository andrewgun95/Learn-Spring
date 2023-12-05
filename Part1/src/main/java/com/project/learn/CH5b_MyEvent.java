package com.project.learn;

import org.springframework.context.ApplicationEvent;

public class CH5b_MyEvent extends ApplicationEvent {

    public CH5b_MyEvent(String source) {
        super(source);
    }

    @Override
    public String toString() {
        return "My Event was occurred on " + source;
    }
}
