package com.project.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component // will automatically defined <bean id="speak" class="com.project.entity.Speak" />
public class Speak {

    private String[] text;
    private String randomText;

    public Speak() {
    }

    public String[] getText() {
        return text;
    }

    @Autowired
    public void setText(@Value("Sunny day, Windy day, Rainy day") String[] text) { // declaring an array using Value Annotations
        this.text = text;
    }

    /**
     * get random text from all possible text
     * @return text
     */
    public String getRandomText(){
        return randomText;
    }

    @PostConstruct
    public void init(){
        int index = (int) (Math.random() * getText().length);
        randomText = getText()[index];
    }

    @Override
    public String toString() {
        return "Speak{" +
                "text=" + Arrays.toString(text) +
                ", randomText='" + randomText + '\'' +
                '}';
    }
}
