package com.project.learn;

import com.project.entity.Circle;
import com.project.entity.Triangle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class CH1_BeanFactory {

    // What is SPRING ?
    // Spring just a CONTAINER of beans (objects)

    // NOT JUST A CONTAINER !

    // Spring does manage these objects inside container to
    // (1) handle *instantiation*
    // (2) handle *object life cycle* and *destruction*

    // Spring use FACTORY PATTERN

    // imagine : factory to producing an object, when request occur

    //          request id  ________________
    // Object   ---------> | Bean Factory   | need id
    // (+) Bean <--------- | new Bean()     | ------> blueprint (in xml)
    //          response    ''''''''''''''''

    // Bean Property has ID and CLASS
    // ID - for reference to specific bean
    // CLASS - which class will be initiate

    public static void main(String[] args) {
        // BEFORE
        Circle circle = new Circle(); // object creating by me
        System.out.println(circle);
        Triangle triangle = new Triangle();
        triangle.setType("equilateral");
        System.out.println(triangle);

        // AFTER
        // initialize bean factory to access spring container
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("./ch1.xml"));
        // get bean object by search specific id from spring container
        circle = (Circle) factory.getBean("circle"); // object creating by a bean factory
        System.out.println(circle);
        triangle = (Triangle) factory.getBean("triangle");
        System.out.println(triangle);

        // WHAT ADVANTAGE DOING THIS ?
        // When complicated initiate class become more easy using bean factory
        // Only just specify inside the xml file, you call how many times do you want
    }
}
