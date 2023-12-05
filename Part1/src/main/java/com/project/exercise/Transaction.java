package com.project.exercise;

public class Transaction {

    private Item item;
    private String status;

    public Transaction() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "item=" + item +
                ", status='" + status + '\'' +
                '}';
    }
}
