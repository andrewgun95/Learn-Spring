package com.project.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Order {

    private String id;
    private String date;
    private int totalAmount;

    private Customer costumer;
    private Product product;

    public Order(){}

    public String getId() {
        return id;
    }

    // make sure id not set into null, id is required member variable
    @Required
    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCostumer() {
        return costumer;
    }

    // customer property will automatically wiring, if some condition meet
    @Autowired
    @Qualifier("orderRelated")
    public void setCostumer(Customer costumer) {
        this.costumer = costumer;
    }

    public Product getProduct() {
        return product;
    }

    // product property will automatically wiring, specific byName
    // @Resource(name = "product1")
    // if not specify the name, will look at the same name with object name property
    @Resource // same as @Resource(name = "product")
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", totalAmount=" + totalAmount +
                ", costumer=" + costumer +
                ", product=" + product +
                '}';
    }

    // custom post-init method
    @PostConstruct
    public void init(){
        System.out.println(getClass().getCanonicalName() + " initializing");
    }

    // custom pre-destroy method
    @PreDestroy
    public void destroy(){
        System.out.println(getClass().getCanonicalName() + " close resources");
    }
}
