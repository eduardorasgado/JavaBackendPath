package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.simpleprotected;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private final List<PublicMemento> history;
    public CareTaker() {
        history = new ArrayList<>();
    }


    public void add(Originator originator) {
        history.add(originator.createMemento());
    }

    public void restore(Originator originator, int index) {
        originator.setMemento(history.get(index));
    }
}
