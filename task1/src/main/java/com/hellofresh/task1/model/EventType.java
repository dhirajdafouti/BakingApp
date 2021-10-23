package com.hellofresh.task1.model;

public enum EventType {

    HOT("Hot"),
    Cold("Cold"),
    MEDIUM_HOT("MediumHot"),
    NONE("None");

    private final String displayName;

    EventType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}


