package com.hellofresh.task1.model;


import org.jetbrains.annotations.TestOnly;

public class Recipe {
    private int id;
    private String title;
   @TestOnly
    public Recipe(int id, String title, EventType event) {
        this.id = id;
        this.title = title;
        this.event = event;
    }

    private EventType event;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public EventType getEvent() {
        return event;
    }

    public Recipe() {

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
