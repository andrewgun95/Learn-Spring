package com.project.learn;

import com.project.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH3f_BeanFactoryPostProcessor {

    // Bean Factory Post Processor
    // * implement to perform some logic on the bean factory instances (operate on bean factory instances)
    // * mean : called on bean factory created

    // What is used for?
    // (1) Allow for custom modification of an application context
    // (2) Useful for custom config file (such as .properties)

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch3f.xml");

        // do stuff ...
        Account account1 = (Account) context.getBean("account1");
        System.out.println(account1);

        ((ClassPathXmlApplicationContext) context).close();
    }
}