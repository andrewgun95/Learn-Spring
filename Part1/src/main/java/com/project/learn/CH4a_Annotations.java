package com.project.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH4a_Annotations {

    // Annotation
    // * used to provide meta data for your Java code
    // * usually meta data contain same information to give instruction at,
    //   (1) Compiler - when we type a java code
    //   (2) Build-time - when we want build into .jar
    //   (3) Runtime - when we run a java code

    // Spring Annotation
    // * used to provide meta data for specific code on Spring
    // * metadata will give instruction at runtime on Spring to make some behavior
    //   such as : create an exception when miss some set properties, auto wiring, etc

    // Checking all Spring Annotation run in BEAN POST PROCESSING

    // A. Required Annotation
    //    * create an exception when miss some wiring to required properties

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch4a.xml");

        // do stuff ...

        ((ClassPathXmlApplicationContext) context).close();
    }

}
