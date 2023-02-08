package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.operations;

public class NumberExpression implements Expression{
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
