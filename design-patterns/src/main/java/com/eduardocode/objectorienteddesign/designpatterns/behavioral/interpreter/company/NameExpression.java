package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.company;

public class NameExpression implements Expression {
    private final String value;
    public NameExpression(String value) {
        this.value = value;
    }


    @Override
    public boolean interpret(Employee employee) {
        return value.equalsIgnoreCase(employee.getName());
    }
}
