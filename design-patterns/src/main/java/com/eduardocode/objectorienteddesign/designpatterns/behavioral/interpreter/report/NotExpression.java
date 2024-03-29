package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.report;

public class NotExpression implements PermissionExpression {
    private final PermissionExpression expression;

    public NotExpression(PermissionExpression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(User user) {
        return !expression.interpret(user);
    }

//    @Override
//    public String toString() {
//        return "NOT " + expression;
//    }


    @Override
    public String toString() {
        return "NotExpression{" +
                "expression=" + expression +
                '}';
    }
}
