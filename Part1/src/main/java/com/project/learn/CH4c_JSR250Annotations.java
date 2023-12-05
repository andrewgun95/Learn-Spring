package com.project.learn;

import com.project.entity.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH4c_JSR250Annotations {

    // JSR-250 is Java Specification Request with the objective to develop annotations
    // for common semantic concept in the Java SE and Java EE platforms that apply across
    // a variety of individual technologies

    // C. Resource Annotation
    // * perform auto wiring to desired properties specific with byName
    // * if not specify the byName, will look byType, if returning more than single bean,
    //   will look at the same name as the object name property,
    //   other than that will throw an error

    // D. Post Construct
    // * perform custom post-init

    // E. Pre Destroy
    // * perform custom pre-destroy

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch4c.xml");

        // do stuff ...
        Order order1 = (Order) context.getBean("order1");
        System.out.println(order1);

        ((ClassPathXmlApplicationContext) context).close();
    }

}
