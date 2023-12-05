package com.project.learn;

import com.project.hardware.Utility;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH4h_ValueAnnotations {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch4h.xml");

        // do stuff ...
        Utility utility = context.getBean("util", Utility.class);
        utility.scan("Graduate Certificate");
        utility.print("Learn Spring by Example.pdf");

        System.out.println(utility);

        ((ClassPathXmlApplicationContext) context).close();
    }


}
