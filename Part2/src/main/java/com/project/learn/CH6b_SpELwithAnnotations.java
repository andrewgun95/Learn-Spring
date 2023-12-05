package com.project.learn;

import com.project.entity.Robot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH6b_SpELwithAnnotations {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch6b.xml");

        // do stuff ...
        Robot robot = context.getBean("robot", Robot.class);
        System.out.println(robot);

        // calculated something
        System.out.println(robot.getResult());

        ((ClassPathXmlApplicationContext) context).close();
    }


}
