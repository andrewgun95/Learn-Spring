package com.project.learn.extra;

import com.project.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH2c_EX_PNamespace {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("extra/ch2c_ex.xml");

        Account account = context.getBean("account1", Account.class);
        System.out.println(account);

        ((ClassPathXmlApplicationContext) context).close();
    }

}
