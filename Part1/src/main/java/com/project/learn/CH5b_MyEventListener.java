package com.project.learn;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * This class will catch all the event has been publish
 */
@Component
public class CH5b_MyEventListener implements ApplicationListener {

    // onApplicationEvent called if there are some event has been publish
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.toString());
    }
}
