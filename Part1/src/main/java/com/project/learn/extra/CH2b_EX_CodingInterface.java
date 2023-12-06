package com.project.learn.extra;

import com.project.entity.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH2b_EX_CodingInterface {

    public static void main(String[] args) {
        // NOT CHANGE CODE IN HERE !
        ApplicationContext context = new ClassPathXmlApplicationContext("extra/ch2b_ex.xml");
        // Only reference to parent class/interface
        Shape shape = (Shape) context.getBean("shape2");
        shape.draw();
    }

}
