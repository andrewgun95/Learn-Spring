package com.project.logger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("console")
public class ConsoleWriter implements LogWriter {

    private String color;

    public ConsoleWriter() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void write(String str) {
        System.out.println("Writing into a console...");
        if(color != null && color.equals("red")) // short circuit condition
            System.err.println("Console : "+str);
        else
            System.out.println("Console : "+str);
    }

}
