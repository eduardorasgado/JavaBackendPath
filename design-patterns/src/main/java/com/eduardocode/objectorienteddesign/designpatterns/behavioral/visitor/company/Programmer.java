package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.company;

public class Programmer extends AbstractEmployee {

    private final String programmingLanguage;
    public Programmer(String name, String programmingLanguage) {
        super(name);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
