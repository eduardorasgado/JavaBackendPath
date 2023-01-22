package com.eduardocode.designpatterns.behavioral.strategy.operations;

public class Division implements OperationStrategy {

    @Override
    public double execute(double left, double right) {
        return left / right;
    }
}
