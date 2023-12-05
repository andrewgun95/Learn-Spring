package com.project.entity;

import org.springframework.stereotype.Component;

// will make class customer automatically be created into a bean, with definition as
// <bean id="customer" class="com.project.entity.Customer" />
// @Component // customer class role as component (bean)
// you can also specify bean id by supplying value argument in the annotation
@Component("cust")
public class Customer {

    private String name;
    private String city;
    private String country;
    private String phone;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
