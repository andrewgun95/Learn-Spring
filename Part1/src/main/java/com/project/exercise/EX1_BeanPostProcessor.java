package com.project.exercise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EX1_BeanPostProcessor {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ex1.xml");
        // bean objects transaction1 and item1 will not getting processed by all BeanPostProcessors
        // because have dependency with bean post processors it self

        Transaction transaction1 = (Transaction) context.getBean("transaction1");
        System.out.println(transaction1);

        // initialize card payment
        context.getBean("payment1");

        System.out.println(transaction1);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
