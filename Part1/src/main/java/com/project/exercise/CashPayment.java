package com.project.exercise;

public class CashPayment implements IPayment {

    private int nominal;
    private int refund;

    public CashPayment() {
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int getRefund() {
        return refund;
    }

    public void setRefund(int refund) {
        this.refund = refund;
    }

    @Override
    public boolean process(Item item) {
        System.out.println("Processing cash payment");
        if (nominal < item.getPrice() * item.getQty()) {
            System.out.println("Your money isn't enough to buy " + item.getName());
            return false;
        }
        refund = nominal - item.getPrice() * item.getQty();
        System.out.println("Payment success !");
        System.out.println("Item : " + item.getName() + " already buy");
        System.out.println("Get refund : " + refund);
        return true;
    }

    public void init() {
        System.out.println(getClass().getName() + " initializing");
        if (getNominal() == 0) System.out.println("You haven't set any nominal");
    }

    @Override
    public String toString() {
        return "CashPayment{" +
                "nominal=" + nominal +
                ", refund=" + refund +
                '}';
    }
}
