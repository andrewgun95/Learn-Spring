package com.project.learn;

import com.project.entity.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CH0_HelloWorld {

    public static void main(String[] args) {
        // initialization application context to access spring container
        ApplicationContext context = new FileSystemXmlApplicationContext("./ch0.xml");

        // get bean object by search specific id from spring container
        Hello hello = (Hello) context.getBean("hello");
        hello.print();
    }

}
