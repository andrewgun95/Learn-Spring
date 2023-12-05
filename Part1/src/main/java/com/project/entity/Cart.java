package com.project.entity;

public class Cart {

    private String id;
    private int amount;

    private Cart next;

    public Cart() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Cart getNext() {
        return next;
    }

    public void setNext(Cart next) {
        this.next = next;
    }
}
