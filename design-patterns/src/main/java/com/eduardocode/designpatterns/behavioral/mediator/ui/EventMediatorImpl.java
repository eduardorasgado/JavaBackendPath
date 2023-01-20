package com.eduardocode.designpatterns.behavioral.mediator.ui;

import java.util.ArrayList;
import java.util.List;

public class EventMediatorImpl implements EventMediator {
    private final List<EventHandler> eventHandlers;

    public EventMediatorImpl() {
        eventHandlers = new ArrayList<>();
    }

    public void register(EventHandler eventHandler) {
        if(!eventHandlers.contains(eventHandler)) {
            eventHandlers.add(eventHandler);
        }
    }

    @Override
    public void remove(EventHandler eventHandler) {
        eventHandlers.remove(eventHandler);
    }

    @Override
    public void send(Event event) {
        for (EventHandler handler :
                eventHandlers) {
            handler.handle(event);
        }
    }
}
