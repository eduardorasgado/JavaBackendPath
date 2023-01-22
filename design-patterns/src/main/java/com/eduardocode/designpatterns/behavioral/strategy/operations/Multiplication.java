package com.eduardocode.designpatterns.behavioral.strategy.operations;

public class Multiplication implements OperationStrategy {

    @Override
    public double execute(double left, double right) {
        return left * right;
    }
}
