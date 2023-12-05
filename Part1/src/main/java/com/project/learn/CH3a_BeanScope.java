package com.project.learn;

import com.project.entity.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH3a_BeanScope {

    // BEAN SCOPE is all about how beans are initialize
    // (1) Singleton (or Eiger) : only once initialize per spring container
    // INITIALIZE DURING LOAD
    // How it works ?
    // * When initialize application context, every bean in .xml config will automatically created
    // * When called getBean() or ref="" happen, get reference to same instance (not newly created)
    // (2) Prototype (or Lazy) : new bean created with every reference
    // INITIALIZE DURING REFERENCE
    // How it works ?
    // * When called getBean() or ref="" happen, will wait for initialize bean, and then get reference to newly created bean

    // Application Context by default is Singleton

    // OTHER SCOPE - Web-aware context bean scope
    // (1) Request : new bean per *servlet request*
    // (2) Session : new bean per *session*
    // (3) Global  : new bean per *global HTTP session*

    public static void main(String[] args) {
        // When use application context, you can choose between bean scope of (1) singleton or (2) prototype
        // When use bean factory, you only choose bean scope of (1) prototype
        ApplicationContext context = new ClassPathXmlApplicationContext("ch3a.xml");
        long time = System.nanoTime();
        Triangle triangle1 = (Triangle) context.getBean("triangle1"); // use prototype
        time = System.nanoTime() - time;
        System.out.println("triangle1 is created in " + time + " ns");

        time = System.nanoTime();
        Triangle triangle2 = (Triangle) context.getBean("triangle2"); // use singleton
        time = System.nanoTime() - time;
        System.out.println("triangle2 is created in " + time + " ns");
    }

}
