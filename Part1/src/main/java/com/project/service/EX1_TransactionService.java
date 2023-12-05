package com.project.service;

import com.project.exercise.IPayment;
import com.project.exercise.Transaction;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EX1_TransactionService implements BeanPostProcessor{

    private Transaction transaction;

    public EX1_TransactionService(){}

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof IPayment)
            transaction.setStatus(((IPayment) bean).process(transaction.getItem()) ? "paid" : "unpaid");
        return bean;
    }
}
