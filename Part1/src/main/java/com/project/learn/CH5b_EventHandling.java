package com.project.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH5b_EventHandling {

    // Work in EVENT HANDLING
    // A. Event Publisher : publishing an event from bean source
    //    * by default spring publishing ContextRefreshEvent when application run
    // B. Event Listener : listen to event has been publishing
    // C. Event : contain information about event

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch5b.xml");

        // do stuff ...
        context.publishEvent(new CH5b_MyEvent("main"));

        ((ClassPathXmlApplicationContext) context).close();
    }

}
