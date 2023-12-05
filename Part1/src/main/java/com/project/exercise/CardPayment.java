package com.project.exercise;

public class CardPayment implements IPayment {

    private int nominal;
    private int limit;

    public CardPayment() {
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean process(Item item) {
        System.out.println("Processing card payment");
        if (nominal + item.getPrice() * item.getQty() > limit) {
            System.out.println("You reach maximum credit card limit");
            return false;
        }
        nominal += item.getPrice() * item.getQty();
        System.out.println("Payment success !");
        System.out.println("Item : " + item.getName() + " already buy");
        System.out.println("Your credit card balance : " + nominal);
        return true;
    }

    public void init() {
        System.out.println(getClass().getName() + " initializing");
        if (getNominal() == 0) System.out.println("You haven't set any nominal");
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                "nominal=" + nominal +
                ", limit=" + limit +
                '}';
    }
}
