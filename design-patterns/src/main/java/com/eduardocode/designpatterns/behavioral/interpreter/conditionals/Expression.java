package com.eduardocode.designpatterns.behavioral.interpreter.conditionals;

import java.util.Map;

public interface Expression {
    boolean interpret(Map<String, Boolean> context);
}
