 package com.project.learn;

 import com.project.service.DummyService;
 import org.springframework.context.ApplicationContext;
 import org.springframework.context.support.ClassPathXmlApplicationContext;

 public class CH8a_IntroAOP {

    // INTRO
    // 1. Functional Programming
    //    * think about problem, and break-down into different function
    //      (each function accomplish particular unit of problem)
    //    * all concern for one whole problem
    //    PROBLEM : COMPLEX DESIGN, INVOLVE A LOT OF FUNCTION ! HARD TO WRITE !

    // 2. Object Oriented Programming
    //    * think about problem, and break-down into individual entity
    //      (each entity have different role to accomplish of particular problem)
    //    * separated concern for one whole problem
    //    PROBLEM : COMPLEX DESIGN ! EASY TO WRITE !, BUT EVERY CONCERN INVOLVE,
    //              ALSO CONCERN WHICH IS NOT PROBLEM DOMAIN

    // EX :
    // in Code :
    // class A {
    //      private Logger logger;
    // }
    // class B {
    //      private Logger logger;
    // }
    // class C {
    //      private Logger logger;
    // }
    //
    // in Design :
    // obj A depend on Logger
    // obj B depend on Logger
    // obj C depend on Logger
    //
    // * in Design, object Logger is the most important, cause every object depend on Logger
    // * Logger is *CROSS CUTTING* objects - not part of business logic, but needed !

    // Common cross cutting objects :
    // A. Logging
    // B. Transactions
    // C. Security
    // etc...

    // WE WANT DESIGN INVOLVE ONLY BUSINESS MODEL (DON'T CARE ABOUT CROSS CUTTING STUFF)

    // 3. Aspect Oriented Programming
    //    * separated concern for one whole business problem and
    //      any concern which not part of business problem, take care by Aspect
    //      advantage : not change for all code occur, only in the aspect

    // in Code :
    // class A {
    //      some business logic ... (do not refer to logging and stuff)
    // }
    // class B {
    //      some business logic ... (do not refer to logging and stuff)
    // }
    // class C {
    //      some business logic ... (do not refer to logging and stuff)
    // }
    // class LoggingAspect {
    //      write aspect configuration, specify which object for this aspect apply to
    // }

    // Aspect *wrapping around methods*

    // method called
    // |
    // v
    // -----> aspect code -> target method -> aspect code ----->
    // A. Before target methods
    // B. After target methods

    // STEPS IN AOP
    // 1. Write Aspects
    // 2. Configure where the aspects apply

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch8a.xml");

        // do stuff ...
        DummyService dummy = context.getBean("dummy", DummyService.class);
        System.out.println(dummy);

        System.out.println(dummy.getPerson().getName());
        System.out.println(dummy.getHouse().getName());

        ((ClassPathXmlApplicationContext) context).close();
    }

}
