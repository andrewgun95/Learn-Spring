package com.project.learn;

import com.project.entity.Robot;
import com.project.entity.Speak;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH6a_IntroSpEL {

    // Spring Expression Language (SpEL for short)
    // * (1) expression language that supports querying and manipulating an object graph at run time
    //   ex : person is Object already defined as a bean
    //        person.setName("Marco").setAge(21).setGender("male").getData()
    // * offer addition features - method invocation, etc
    // * (2) evaluated expression
    //       * parse an expression into another expression with evaluating
    //  ex : evaluated math expression
    //       5 + 6 + T(Math).PI -> 14.14

    // SpEL normally used for creating XML or annotated based definition

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch6a.xml");

        // do stuff ...
        Robot robot = context.getBean("robot", Robot.class);
        System.out.println(robot);

        Speak speak = context.getBean("speak", Speak.class);
        System.out.println(speak);

        ((ClassPathXmlApplicationContext) context).close();
    }

}
