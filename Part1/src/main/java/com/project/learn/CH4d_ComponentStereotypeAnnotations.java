package com.project.learn;

import com.project.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH4d_ComponentStereotypeAnnotations {

    // F. Stereotype Annotations
    // * perform *auto bean definition* (automatically create a class into a bean)

    // * for each class only have one instance of bean definition
    // ex :
    //                   in config (.xml)
    // class Customer -> <bean id="customer" class="com.project.entity.Customer" />
    // class Order    -> <bean id="order" class="com.project.entity.Order" />
    // class Product  -> <bean id="product" class="com.project.entity.Product" />

    // CAN'T PERFORM AUTO BEAN DEFINITION FOR

    // class Order    -> <bean id="order1" class="com.project.entity.Order" />
    //                   <bean id="order2" class="com.project.entity.Order" />

    // * Apart, perform auto bean definition, Stereotype annotations is actually used for :
    // * MARKER for any class that fulfills a STANDARD ROLE within an application

    // The four types of stereotype annotation roles :
    // @Component  : generic stereotype for specify any class which will create to a bean
    //               * generic mean doesn't have role
    // @Repository : stereotype for specify any class role as persistence layer
    // @Service    : stereotype for specify any class role as service layer
    // @Controller : stereotype for specify any class role as presentation layer

    // Where to use stereotype ?
    // Always use over CONCRETE CLASSES, not over interfaces
    // (1) @Controller is for a class as a Spring Web MVC Controller
    // (2) @Service is for a class as a Service of application (business logic)
    // (3) @Repository is for Data Object Access (database access logic)
    // (4) @Component used when your class does not fall into either of three categories
    //     i.e. Controller, Services, and Repository

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch4d.xml");

        // do stuff ...
        Customer customer = (Customer) context.getBean("cust");
        System.out.println(customer);

        ((ClassPathXmlApplicationContext) context).close();
    }

}
