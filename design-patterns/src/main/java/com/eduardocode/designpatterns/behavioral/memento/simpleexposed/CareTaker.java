package com.eduardocode.designpatterns.behavioral.memento.simpleexposed;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CareTaker {
    private List<Memento> history;

    public CareTaker() {
        this.history  = new ArrayList<>();
    }

    public void add(Memento memento) {
        if(!history.contains(memento)) {
            history.add(memento);
        }
    }

    public Memento get(int index) {
        if(index < history.size()) {
            return history.get(index);
        }
        throw new NoSuchElementException();
    }
}
