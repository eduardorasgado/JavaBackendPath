package com.eduardocode.designpatterns.behavioral.mediator.ui;

public class Event {
    private EventType type;
    private String name;

    public Event(EventType type, String name) {
        this.type = type;
        this.name = name;
    }

    public EventType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
