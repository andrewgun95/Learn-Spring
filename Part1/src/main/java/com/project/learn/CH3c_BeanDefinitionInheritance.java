package com.project.learn;

import com.project.entity.Employee;
import com.project.entity.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH3c_BeanDefinitionInheritance {

    // BEAN DEFINITION INHERITANCE is helping create a template to bean definition

    // When works with a lot of bean, will make bean definition much easier .
    // How it works ?
    // * just use inherit the template from general bean definition to specific bean definition

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch3c.xml");
        Employee employee1 = (Employee) context.getBean("employee1");
        System.out.println(employee1);
        Employee employee2 = (Employee) context.getBean("employee2");
        System.out.println(employee2);

        Team team1_support = (Team) context.getBean("team1_support");
        System.out.println(team1_support);
        Team team1 = (Team) context.getBean("team1");
        System.out.println(team1);
    }

}
