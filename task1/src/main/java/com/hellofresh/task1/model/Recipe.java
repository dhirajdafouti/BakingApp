package com.hellofresh.task1.model;


import org.jetbrains.annotations.TestOnly;

/**
 * This class will holds the data related to Recipe Selected by the User.
 */
public class Recipe {
    private int id;
    private String title;
    private EventType event;

    @TestOnly
    public Recipe(int id, String title, EventType event) {
        this.id = id;
        this.title = title;
        this.event = event;
    }

    public Recipe() {

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public EventType getEvent() {
        return event;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEvent(EventType event) {
        this.event = event;
    }
}
