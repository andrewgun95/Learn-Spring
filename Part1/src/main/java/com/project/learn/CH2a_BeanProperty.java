package com.project.learn;

import com.project.entity.Circle;
import com.project.entity.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CH2a_BeanProperty {

    // BEAN FACTORY vs APPLICATION CONTEXT
    // Goal : to access or reach spring beans from the container

    // BEAN FACTORY
    // * root interface
    // Features :
    // (1) Bean instantiation / wiring
    // Implement use LAZY LOADING
    // * only instantiating when we directly called them through the getBean() method

    // APPLICATION CONTEXT
    // * central interface (core interface for *Spring Application*)
    // Features :
    // (1) Bean instantiation / wiring
    // (2) Automatic BeanPostProcessor registration
    // (3) Automatic BeanFactoryPostProcessor registration
    // (4) Convenient MessageSource access (for i18n)
    // (5) ApplicationEvent publication
    // Implement use EAGER LOADING
    // * all beans instantiate after the ApplicationContext started up

    // Almost enterprise application use ApplicationContext because have more features and more capabilities
    // except : for Android with memory consumption might be critical

    public static void main(String[] args) {
        // initialization application context to access spring container
        ApplicationContext context1 = new FileSystemXmlApplicationContext("./ch1.xml");
        // get bean object by search specific id from spring container
        Triangle triangle = (Triangle) context1.getBean("triangle");
        System.out.println(triangle);

        // FILE SYSTEM -> root folder in the working directory
        // in this case working directory is D:\Penting\Learn Spring
        // CLASS PATH  -> (1) root folder in the folder resources (created by maven configuration)
        //                (2) root folder in the folder java      (created by intellij idea - mark with blue)
        // in this case
        // Part1
        // (+) src
        //     (+) main
        //         (+) java      (classpath created by intellij idea)
        //             (+) com.project.
        //         (+) resources (classpath created by maven configuration)
        //     (+) test


        ApplicationContext context2 = new ClassPathXmlApplicationContext("ch2a.xml");
        // same as before

        // Object object = (Object) context.getBean("id");
        // do stuff with object ...

        // Description : use setter injection
        Triangle myTriangle = (Triangle) context2.getBean("triangle");
        System.out.println(myTriangle); // result : name = "myTriangle", type = "equilateral", size = 10

        // Description : use constructor injection (3 args)
        Circle myCircle = (Circle) context2.getBean("circle");
        System.out.println(myCircle);   // result : name = "myCircle", type = "oval", radius = 5

        // Description : use constructor injection (2 args)
        Circle myCircle1 = (Circle) context2.getBean("circle1");
        System.out.println("PROBLEM : "+myCircle1);  // result : name = "myCircle", type = "10", radius = 0

        // Description : use constructor injection (2 args specify with type)
        Circle myCircle2 = (Circle) context2.getBean("circle2");
        System.out.println(myCircle2);  // result : name = "myCircle", type = null, radius = 10

        // Description : use constructor injection (2 args specify with name)
        Circle myCircle3 = (Circle) context2.getBean("circle3");
        System.out.println(myCircle3);  // result : name = "myCircle", type = null, radius = 10

        // Description : use constructor injection (1 args)
        Circle myCircle4 = (Circle) context2.getBean("circle4");
        System.out.println(myCircle4);  // result : name = null, type = null, radius = 10

        // Description : use constructor injection (3 args - ordered by indexes)
        Circle myCircle5 = (Circle) context2.getBean("circle5");
        System.out.println(myCircle5);
    }

}
