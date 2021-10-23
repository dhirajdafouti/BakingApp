package com.hellofresh.task1.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SubscriptionTest {

    Subscription subscription;

    @Before
    public void setUp() {
        subscription = new Subscription();
    }

    @Test
    public void testSubscriptionIdValue() {
        subscription.setId(1234);
        assertEquals(1234, subscription.getId());
    }

    @Test
    public void testSubscriptionDeliveryDay() {
        subscription.setDeliveryDay(12042021);
        assertEquals(12042021, subscription.getDeliveryDay());
    }

    @Test
    public void testRecipeEventTypeValue() {
        subscription.setForFamily(true);
        assertTrue(subscription.isForFamily());

    }

    @After
    public void tearDown() {
        subscription = null;
    }

}