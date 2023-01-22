package com.eduardocode.designpatterns.behavioral.strategy.operations;

public class Context {

    private OperationStrategy strategy;

    public double executeStrategy(double left, double right) {
        return getStrategy().execute(left, right);
    }

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public OperationStrategy getStrategy() {
        return strategy;
    }
}
