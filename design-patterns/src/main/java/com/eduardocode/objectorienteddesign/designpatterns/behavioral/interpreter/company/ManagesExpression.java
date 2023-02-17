package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.company;

import java.util.Arrays;

public class ManagesExpression implements Expression {
    private final String value;

    public ManagesExpression(String value) {
        this.value = value;
    }

    @Override
    public boolean interpret(Employee employee) {
        if(!employee.isManager()) {
            return false;
        }

        return Arrays.stream(employee.teamNames().split(","))
                .anyMatch(target -> target.trim().equalsIgnoreCase(value));
    }
}
