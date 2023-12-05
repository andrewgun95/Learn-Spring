package com.project.learn;

import com.project.entity.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH3b_AwareInterface {

    // There some interface provide by Spring to get access all information
    // when spring container is created on bean class definition

    // For example :
    // using : setter based injection to set all the information
    //         * happen when creating a spring container *

    // What information ?
    // application context used when initialize spring container - using ApplicationContextAware,
    // bean name used when initialize a particular bean, etc - using BeanNameAware

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch3b.xml");
        Triangle triangle1 = (Triangle) context.getBean("triangle1");
        triangle1.draw();

        long time = System.nanoTime();
        System.out.println("Point A " + triangle1.getPointA());
        time = System.nanoTime() - time;
        System.out.println("Get point A in " + time + " ns");

        time = System.nanoTime();
        System.out.println("Point A "+ triangle1.getProtoPointA());
        time = System.nanoTime() - time;
        System.out.println("Get prototype point A in " + time + " ns");
    }

}
