package com.eduardocode.designpatterns.behavioral.interpreter.conditionals;

import java.util.Map;

public class ConditionalsDemo {

    public static void main(String[] args) {
        Map<String, Boolean> context = Map.of("A", true, "B", false, "C", true);
        Expression andExpression = new AndExpression(new TerminalExpression("A"), new TerminalExpression("B"));
        Expression orExpression = new OrExpression(andExpression, new TerminalExpression("C"));

        System.out.println(orExpression.interpret(context));
    }
}
