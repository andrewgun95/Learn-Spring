package com.project.learn;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class CH3e_DisplayNameBeanPostProcessor implements BeanPostProcessor {

    // these method run for each bean created

    // before initialization
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Before initialization of "+beanName);
        return bean;
    }

    // after initialization
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("After initialization of "+beanName);
        return bean;
    }
}
