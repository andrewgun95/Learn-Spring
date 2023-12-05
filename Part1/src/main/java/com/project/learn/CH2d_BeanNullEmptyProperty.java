package com.project.learn;

import com.project.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH2d_BeanNullEmptyProperty {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch2d.xml");

        Employee employee = (Employee) context.getBean("employee1");
        System.out.println(employee);
    }

}
