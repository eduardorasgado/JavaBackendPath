package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.report;

public class OrExpression implements PermissionExpression {
    private final PermissionExpression left;
    private final PermissionExpression right;

    public OrExpression(PermissionExpression left, PermissionExpression right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public boolean interpret(User user) {
        return left.interpret(user) || right.interpret(user);
    }

//    @Override
//    public String toString() {
//        return left + " OR " + right;
//    }


    @Override
    public String toString() {
        return "OrExpression{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
