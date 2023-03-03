package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.report;

public class OrExpression implements PermissionExpression {
    private PermissionExpression left;
    private PermissionExpression right;

    public OrExpression(PermissionExpression left, PermissionExpression right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public boolean interpret(User user) {
        return false;
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
