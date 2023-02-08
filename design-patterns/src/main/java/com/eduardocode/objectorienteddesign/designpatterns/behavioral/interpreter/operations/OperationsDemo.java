package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.operations;

public class OperationsDemo {

    public static void main(String[] args) {
        Expression plus = new PlusExpression(new NumberExpression(1), new NumberExpression(2));
        Expression minus = new MinusExpression(new NumberExpression(10), new NumberExpression(5));

        Expression plusAndMinus = new MinusExpression(plus, minus);

        System.out.println(plusAndMinus.interpret());

        minus = new MinusExpression(new NumberExpression(15), new NumberExpression(2));
        plusAndMinus = new PlusExpression(plusAndMinus,minus);

        System.out.println(plusAndMinus.interpret());
    }
}
