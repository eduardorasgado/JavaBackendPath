package com.eduardocode.designpatterns.behavioral.strategy.operations;

public class SimpleDemo {

    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new Addition());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context.setStrategy(new Substraction());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context.setStrategy(new Division());
        System.out.println("10 / 2 = " + context.executeStrategy(10, 2));

        context.setStrategy(new Modulus());
        System.out.println("10 % 2 = " + context.executeStrategy(10, 2));

        context.setStrategy(new Multiplication());
        System.out.println("10 * 2 = " + context.executeStrategy(10, 2));
    }
}
