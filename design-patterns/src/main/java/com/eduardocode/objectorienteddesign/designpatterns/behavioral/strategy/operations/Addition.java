package com.eduardocode.objectorienteddesign.designpatterns.behavioral.strategy.operations;

public class Addition implements OperationStrategy {

    @Override
    public double execute(double left, double right) {
        return left + right;
    }
}
