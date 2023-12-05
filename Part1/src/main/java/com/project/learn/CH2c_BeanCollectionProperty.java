package com.project.learn;

import com.project.entity.PhoneBook;
import com.project.entity.Places;
import com.project.entity.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH2c_BeanCollectionProperty {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch2c.xml");

        PhoneBook book1 = (PhoneBook) context.getBean("phonebook1");
        System.out.println(book1);

        Team team1 = (Team) context.getBean("team1");
        System.out.println(team1);

        Team team2 = (Team) context.getBean("team2");
        System.out.println(team2);

        PhoneBook book2 = (PhoneBook) context.getBean("phonebook2");
        System.out.println(book2); // different with phonebook1 only number 089655454395 is disappear
                                   // why ? book2 is using set, not allowed duplicates

        Places places1 = (Places) context.getBean("places1");
        System.out.println(places1);

        Places places2 = (Places) context.getBean("places2");
        System.out.println(places2);
    }

}
