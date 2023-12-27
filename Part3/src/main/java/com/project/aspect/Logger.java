package com.project.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("logger")
public class Logger {

    /**
     *  INSERT METHOD THAT CAN BE APPLY TO ANY OTHER TARGET METHOD IN BEAN OBJECT, BEFORE AND AFTER
     */

    // BEFORE :
    // run these method before execution(target_method_signature)

    @Before("execution(public String getName())") // * for every 'public String getName()'
    public void advice0(){
        System.out.println("Advice run. Get name method called");
    }

    @Before("execution(public String com.project.model.Person.getName())") // * only for 'public String getName()' on class Person
    public void advice1(){
        System.out.println("Advice run. Get name method called on class Person");
    }

    // What is advice ?

}
