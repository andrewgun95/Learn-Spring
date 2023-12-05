package com.project.learn;

import com.project.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH3d_BeanLifeCycle {

    // REVIEW :
    // What Spring Application Context do ?
    // (1) responsible to initialize the Spring Beans defined in Spring Bean configuration file (.xml)
    // (2) responsible for injection dependencies in the Spring Beans
    //     * injection through Setter, Constructor, or Spring Auto-wire

    // Spring Bean Life Cycle, provide some customize code to be executed at
    // (1) after initialize a bean (post-init)
    // (2) before destroy a bean (pre-destroy)
    //     * destroy will not work when using bean scope prototype

    // Why we need customize code in post-init or pre-destroy ?
    // * sometimes we need to initialize a resources, creating database connection,
    // * validating third party service at the time before any client request

    // Spring provide 3 different ways to add some customize code at post-init and pre-destroy
    // (1) via InitializingBean and DisposableBean interface
    //     * not recommended, will create tight coupling with Spring
    // (2) via init-method and destroy-method in configuration file (.xml)
    //     * recommended, no tight coupling with Spring, we can create our method
    // (3) via @PosConstruct and @PreDestroy annotation
    //     * recommended

    // * post-init and pre-destroy should have no arguments

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch3d.xml");

        // do stuff here ...
        Employee employee1 = (Employee) context.getBean("employee1");
        System.out.println(employee1);

        Employee employee2 = (Employee) context.getBean("employee2");
        System.out.println(employee2);

        Employee employee3 = (Employee) context.getBean("employee3");
        System.out.println(employee3);

        // context.close() will make every bean in application context destroyed
        ((ClassPathXmlApplicationContext) context).close();

        // when context getting closed, beans are destroyed in reverse order (in STACK, Last-In-First-Out)

        // initialize order (in XML order)
        // CH3d_EmployeeService1 -> CH3d_EmployeeService2 -> CH3d_EmployeeService3
        // (first)                                           (last)

        // destroy order
        // CH3d_EmployeeService3 -> CH3d_EmployeeService2 -> CH3d_EmployeeService1
        // (last)                                            (first)
    }

}
