package com.project.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CH5a_InternationalizationMessages {

    // APPLICATION CONTEXT SUPPORT
    // INTERNATIONALIZATION (called i18n -> "i-eighteen letters-n") MESSAGING
    // * create software which can be easily adapted to specific local languages and cultures
    // A. Translation enablement
    // B. Localization enablement
    // includes,
    // 1. Allowing space in user interfaces for translation into languages that require more characters
    // 2. Developing with Unicode standard (such as UTF-8 in HTML, XML, JSP, PHP, etc) (STANDARD WEB PAGE)
    // 3. Using written that have global meaning
    // 4. Ensuring data space so that messages can be translated from languages with single-byte character code
    //    (such as English) into language requiring multiple-byte character code (such as Japanese)

    // in user interface -> code refer to some properties file, instead make a hard coding

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch5a.xml");

        // do stuff ...
        String name = "Andrew";

        // get message no params
        String message0 = context.getMessage("welcome.test", null, "Default message", null);
        // * when code (key) couldn't find in properties file, will return default message
        System.out.println(message0);

        // get message with params
        String message1 = context.getMessage("welcome.message", new Object[]{name}, "Default message", null);
        System.out.println(message1);

        // get message with params
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");

        String message2 = context.getMessage("welcome.greeting", new Object[]{formatter.format(now)}, "Default messages", null);
        System.out.println(message2);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
