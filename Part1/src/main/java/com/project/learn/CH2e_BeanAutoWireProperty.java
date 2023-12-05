package com.project.learn;

import com.project.entity.Employee;
import com.project.entity.Family;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH2e_BeanAutoWireProperty {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch2e.xml");

        Family myFamily = (Family) context.getBean("myFamily");
        System.out.println(myFamily);

        Employee employee1 = (Employee) context.getBean("employee1");
        System.out.println(employee1);

        Family family1 = (Family) context.getBean("family1");
        System.out.println(family1);
    }

}
