package com.prototype.joint.findmyseat;

import java.util.Date;
public class Order {
    private int orderId;
    private int numOfPeople;
    private Date date;
    public Order(int orderId, int numOfPeople, Date date) {
        this.orderId = orderId;
        this.numOfPeople = numOfPeople;
        this.date = date;
    }
    public int getNumOfPeople() {
        return numOfPeople;
    }
    public Date getDate() {
        return date;
    }
    public int getID() {
        return orderId;
    }
}
