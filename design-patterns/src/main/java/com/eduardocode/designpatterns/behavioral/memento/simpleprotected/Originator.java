package com.eduardocode.designpatterns.behavioral.memento.simpleprotected;

public class Originator {
    private String state;

    public void doSomethingPublic() {
        System.out.println("Doing something public and using state within: " + getState());
    }

    private String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public PublicMemento createMemento() {
        return new Memento(this);
    }

    public void setMemento(PublicMemento memento) {
        setState(((Memento) memento).getState());
    }
    
    private static class Memento implements PublicMemento {
        private final String state;

        public Memento(Originator originator) {
            state = originator.getState();
        }

        private String getState() {
            return state;
        }
    }
}
