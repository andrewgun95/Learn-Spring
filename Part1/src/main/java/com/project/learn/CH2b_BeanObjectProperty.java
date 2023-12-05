package com.project.learn;

import com.project.entity.Cart;
import com.project.entity.Family;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CH2b_BeanObjectProperty {

    private static String toString(Cart cart) {
        String str = "";
        Cart current = cart;
        while (current != null) {
            str += "[id=" + current.getId() + "," + current.getAmount() + "]";
            current = current.getNext();
        }
        return str;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch2b.xml");

        // How we get an object which are dependent to other object ?

        // Goal : get Family object

        // (1) get bean object which are dependent to the Family object by search specific id
        // Person person1 = (Person) context.getBean("person1");
        // Person person2 = (Person) context.getBean("person2");
        // (2) initialize Family object by use all dependency
        // Family family = new Family(person1, person2);
        // System.out.println(family);

        // WRONG ! The reason why spring exist is avoid INITIALIZATION MANUALLY

        // RIGHT !,
        // Get bean object which are ROOT bean (not dependent with other bean), and give all
        // the rest of object referencing to the spring
        Family family1 = (Family) context.getBean("familyKu"); // reference to the bean with alias myFamily
        System.out.println(family1);

        Cart train = (Cart) context.getBean("train");
        System.out.println(toString(train));
    }

}
