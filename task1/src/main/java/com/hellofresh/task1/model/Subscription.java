package com.hellofresh.task1.model;

import org.jetbrains.annotations.TestOnly;

public class Subscription {
    public void setId(int id) {
        this.id = id;
    }

    public void setDeliveryDay(long deliveryDay) {
        this.deliveryDay = deliveryDay;
    }

    public void setForFamily(boolean forFamily) {
        isForFamily = forFamily;
    }

    private int id;

    public Subscription() {

    }

    private long deliveryDay;

    public int getId() {
        return id;
    }

    public long getDeliveryDay() {
        return deliveryDay;
    }

    public boolean isForFamily() {
        return isForFamily;
    }

    @TestOnly
    public Subscription(int id, long deliveryDay, boolean isForFamily) {
        this.id = id;
        this.deliveryDay = deliveryDay;
        this.isForFamily = isForFamily;
    }

    private boolean isForFamily;

}
