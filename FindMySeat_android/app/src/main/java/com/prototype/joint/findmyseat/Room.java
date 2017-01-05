package com.prototype.joint.findmyseat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by בעז on 1/4/2017.
 */
public class Room {
    private static int orderId;
    private String  name;
    private int capacity;
    private HashMap<Date, Integer> spotsLeft;
    private boolean isTV;
    private boolean isWhiteboard;
    private int tableType; //0 for personal tables, 1 for meeting table
    private HashMap<Integer, Order> orders;
    public Room() {
        this.name = null;
        this.capacity= 0;
        this.spotsLeft = null;
        this.isTV = false;
        this.isWhiteboard = false;
        this.tableType = 0;
    }
    public Room(String name, int capacity, boolean isTV, boolean isWhiteboard, int tableType) {
        this.name =name;
        this.capacity=capacity;
        this.isTV=isTV;
        this.isWhiteboard=isWhiteboard;
        this.tableType = tableType;
        this.spotsLeft = new HashMap<>();
        this.orders = new HashMap<>();
        orderId = 0;
    }
    public int orderRoom(Date date, int numOfPeople, boolean needTV, boolean needWhiteboard) {
        if ((needTV && !isTV) || (needWhiteboard && !isWhiteboard)) {
            return -1; //no such room available
        }
        if (getFreeSpots(date) >= numOfPeople) {
            Order order = new Order(++orderId, numOfPeople, date);
            orders.put(orderId, order);
            int newCapacity = capacity- numOfPeople;
            if (spotsLeft.containsKey(date)) {
                newCapacity -= spotsLeft.get(date);
            }
            spotsLeft.put(date, newCapacity);
            return orderId;
        }
        return -1; //no such room available
    }
    public void deleteOrder(Order order) {
        if (!orders.containsKey(order.getID())) {
            //TODO: error
        }
        spotsLeft.put(order.getDate(), spotsLeft.get(order.getDate())+order.getNumOfPeople());
        orders.remove(orderId);
    }
    public int getFreeSpots(Date date) {
        return spotsLeft.get(date);
    }

}
