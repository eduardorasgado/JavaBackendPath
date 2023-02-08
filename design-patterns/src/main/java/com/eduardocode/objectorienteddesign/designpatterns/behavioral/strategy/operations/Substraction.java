package com.eduardocode.objectorienteddesign.designpatterns.behavioral.strategy.operations;

public class Substraction implements OperationStrategy {

    @Override
    public double execute(double left, double right) {
        return left - right;
    }
}
