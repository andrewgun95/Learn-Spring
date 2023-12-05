package com.project.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH3e_BeanPostProcessor {

    // Bean Life Cycle activities,
    // (1) Bean Instantiated
    // (2) Dependencies Injection
    // (3) Internal Processing (Post Processing)
    // (4) Custom Init
    // (5) Internal Processing (Post Processing)
    // (6) Bean is ready to used
    // (7) Custom Destroy
    // (8) Bean Destroyed

    // Bean Post Processor
    // * implement to perform some logic when creating bean instances
    // * mean : called on each bean created by bean factory

    // Processing happen when,
    // (1) Before Initialization
    // (2) After Initialization
    //     * perform an action after initialization
    // (3) etc ... (explore by your self)

    // Creating custom bean post processor, on separate class

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch3e.xml");

        // do stuff ...

        ((ClassPathXmlApplicationContext) context).close();
    }
}
