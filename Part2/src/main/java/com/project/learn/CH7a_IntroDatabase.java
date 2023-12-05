package com.project.learn;

import com.project.model.Offer;
import com.project.model.OffersDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;

public class CH7a_IntroDatabase {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch7a.xml");

        OffersDAO offersDAO = context.getBean("offers", OffersDAO.class);
//        System.out.println(offersDAO.getOffers());
//
//        // retrieve
//        System.out.println("Offers from name = 'Sue' : " + offersDAO.getOffers("sue")); // return : 2
//        System.out.println("Offers from id = '2' and name = 'Sue' : " + offersDAO.getOffers(2, "sue")); // return : empty
//        System.out.println("Offers from id = '2' : " + offersDAO.getOffer(2)); // return : 1, Mike
//
//        // delete
//        if (offersDAO.delete(5))
//            System.out.println("Successful deleted offer with id = '5'");

        // System.out.println(offersDAO.getOffers());

        Offer offer1 = new Offer("Dave", "dave@gmail.com", "Coding Java is Fun");
        Offer offer2 = new Offer("Karen", "karen@gmail.com", "Perfectionist, Software tester");

        // create
        // if (offersDAO.create(offer1))
        // System.out.println("Successful created offer named Dave");
        // if (offersDAO.create(offer2))
        // System.out.println("Successful created offer named Karen");

        Offer offer3 = new Offer(9, "Karen", "karen21@ymail.com", "Perfectionist, Software tester");

        // update
        // if(offersDAO.update(offer3))
        // System.out.println("Successful updated offer with id = '9'");

        // create batch
        // List<Offer> offers = new ArrayList<>();
        // offers.add(new Offer("Andrew", "andrew.gun@gmail.com", "Java spring web maintenance"));
        // offers.add(new Offer("Phil", "phil.ja@gmail.com", "Technical operator enhancement"));

        // int numb = offersDAO.create(offers);
        // System.out.println("Created offers of " + numb + " rows");

        // transaction
        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer(15,"Calvin", "calvin.do@gmail.com", "IT staff"));
        offers.add(new Offer(16,"Malvin", "malvin.ph@gmail.com", "IT trainer"));

        try {
            int numb = offersDAO.transaction(offers);
            System.out.println("Created offers of " + numb + " rows");
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        System.out.println(offersDAO.getOffers());

        ((ClassPathXmlApplicationContext) context).close();
    }

}
