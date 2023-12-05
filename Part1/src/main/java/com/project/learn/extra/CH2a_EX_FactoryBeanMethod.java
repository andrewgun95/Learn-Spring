package com.project.learn.extra;

import com.project.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH2a_EX_FactoryBeanMethod {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("extra/ch2a_ex.xml");

        Person person1 = context.getBean("person1", Person.class);
        System.out.println(person1);

        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2);

        ((ClassPathXmlApplicationContext) context).close();
    }

}
