package com.hellofresh.task1.model;

import org.jetbrains.annotations.TestOnly;

/**
 * This class will holds the data for the User Subscription.
 */
public class Subscription {

    private long deliveryDay;
    private int id;
    private boolean isForFamily;

    @TestOnly
    public Subscription(int id, long deliveryDay, boolean isForFamily) {
        this.id = id;
        this.deliveryDay = deliveryDay;
        this.isForFamily = isForFamily;
    }

    public Subscription() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeliveryDay(long deliveryDay) {
        this.deliveryDay = deliveryDay;
    }

    public void setForFamily(boolean forFamily) {
        isForFamily = forFamily;
    }

    public int getId() {
        return id;
    }

    public long getDeliveryDay() {
        return deliveryDay;
    }

    public boolean isForFamily() {
        return isForFamily;
    }


}
