package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.simple;

public class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("Concrete Component Operation");
    }
}
