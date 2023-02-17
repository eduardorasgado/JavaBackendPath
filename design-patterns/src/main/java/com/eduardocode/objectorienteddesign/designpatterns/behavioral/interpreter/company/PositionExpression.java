package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.company;

public class PositionExpression implements Expression {

    private final String value;
    public PositionExpression(String value) {
        this.value = value;
    }

    @Override
    public boolean interpret(Employee employee) {
        return employee.getPosition().equalsIgnoreCase(value);
    }
}
