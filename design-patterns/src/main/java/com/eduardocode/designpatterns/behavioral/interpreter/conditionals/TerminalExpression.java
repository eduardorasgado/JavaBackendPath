package com.eduardocode.designpatterns.behavioral.interpreter.conditionals;

import java.util.Map;

public class TerminalExpression implements Expression {
    private final String variable;

    public TerminalExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public boolean interpret(Map<String, Boolean> context) {
        return context.get(variable);
    }
}
