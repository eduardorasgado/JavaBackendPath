package com.eduardocode.designpatterns.behavioral.mediator.colleagues;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    List<Colleague> colleagues;

    public ConcreteMediator() {
        this.colleagues = new ArrayList<>();
    }

    @Override
    public void send(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            if(!colleague.equals(sender)) {
                colleague.notify(message);
            }
        }
    }

    @Override
    public void setColleague(Colleague colleague) {
        if(!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMediator(this);
        }
    }
}
