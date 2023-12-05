package com.project.learn;

import com.project.entity.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH4b_AutowiredAnnotations {

    // B. Auto wired Annotation
    //    * perform auto wiring to desired properties
    //    * What different in previous auto wired ?
    //      wiring when meet some condition
    //      First  , will look at the type (byType), if return more than one beans have same type
    //      Second , will matching the name (byName), if not match any name,
    //      Third  , will search for qualifier

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch4b.xml");

        // do stuff ...
        Order order1 = (Order) context.getBean("order1");
        System.out.println(order1);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
