package com.project.controller;

import com.project.learn.CH5b_MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

// ALTERNATIVE :
// public class DummyController implements ApplicationContextAware
@Controller
public class DummyController implements ApplicationEventPublisherAware {

    // interface which implement by ApplicationContext
    private MessageSource messageSource;
    // interface which implement by ApplicationContext
    private ApplicationEventPublisher publisher;

    @Autowired
    public void setMessageSource(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher){
        this.publisher = publisher;
    }

    // @Override
    // public void setApplicationContext(ApplicationContext context){
    // }

    @PostConstruct
    public void init(){
        String message = messageSource.getMessage("welcome.message", new Object[]{getClass().getSimpleName()}, "Default Message", null);

        // for loosely couple, getMessage using messageSource
        // by dependency injecting

        System.out.println(message);
        showHome();
    }

    private void showHome(){
        // publish an event
        publisher.publishEvent(new CH5b_MyEvent(getClass().getSimpleName()));

        // for loosely couple, publish an event using ApplicationEventPublisher
        // by implementing interface ApplicationEventPublisherAware
    }

    // What different between Interface and Abstract ?
    // * grouping the class
    // Interface : follow the structure
    // Abstract  : follow the structure, but also can customize the code
}
