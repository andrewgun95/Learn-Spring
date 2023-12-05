package com.project.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // will automatically defined <bean id="robot" class="com.project.entity.Robot" />
public class Robot {

    private String id;
    private String say;

    private String result;

    public Robot() {
    }

    @Autowired
    public void setId(@Value("#{44 + 77}") String id) {
        this.id = id;
    }

    @Autowired
    public void setSay(@Value("#{speak.randomText + ', length : ' + speak.randomText?.length()}") String say) {
        this.say = say;
    }

    // SpEL expression using "spell-out" comparison operator
    // <   : lt
    // <=  : le
    // >   : gt
    // >=  : ge
    // ==  : eq
    // !   : not
    // ||  : or
    // &&  : and

    // additional math operators
    // ^ for power

    // declaring a new object    : new package_name.class_name()
    //                             ex, new java.util.Date()
    // declaring a static object : T(class_name).access_properties
    //                             ex, T(Math).random()
    @Autowired
    public void setResult(@Value("#{new java.util.Date() + ' : ' + ((T(Math).floor(T(Math).random() * 100) / 100) ^ 2 ge 0.5 ? 'good' : 'bad')}") String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id='" + id + '\'' +
                ", say='" + say + '\'' +
                '}';
    }

}
