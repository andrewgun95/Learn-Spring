package com.project.learn.extra;

import com.project.entity.Family;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH2e_EX_DefaultAutoWire {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("extra/ch2e_ex.xml");

        // do stuff ...
        Family family1 = context.getBean("family1", Family.class);
        System.out.println(family1);

        ((ClassPathXmlApplicationContext) context).close();
    }

}
