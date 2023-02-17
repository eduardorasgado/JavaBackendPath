package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.company;

public class AndExpression implements Expression {
    private Expression left;
    private Expression right;

    public AndExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Employee employee) {
        return left.interpret(employee) && right.interpret(employee);
    }

    @Override
    public String toString() {
        return "AndExpression{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
