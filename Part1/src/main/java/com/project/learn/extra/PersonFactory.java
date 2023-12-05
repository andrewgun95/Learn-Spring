package com.project.learn.extra;

import com.project.entity.Person;

public class PersonFactory {

    // another way to instantiate bean, by using other bean as a factory

    // non-static method !

    public Person create(){
        System.out.println("using bean factory "+getClass().getCanonicalName()+" to instantiate");
        return new Person();
    }

    public Person create(String name, int age, String gender){
        System.out.println("using bean factory "+getClass().getCanonicalName()+" to instantiate");
        return new Person(name, age, gender);
    }

}
