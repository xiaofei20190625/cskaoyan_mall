package com.cskaoyan.mall.bean;

import java.util.Date;

public class OrderS {

    Date day;
    Long orders;
    Long customers;
    Double amount;
    Double pcr;


    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Long getOrders() {
        return orders;
    }

    public void setOrders(Long orders) {
        this.orders = orders;
    }

    public Long getCustomers() {
        return customers;
    }

    public void setCustomers(Long customers) {
        this.customers = customers;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPcr() {
        return pcr;
    }

    public void setPcr(Double pcr) {
        this.pcr = pcr;
    }
}
