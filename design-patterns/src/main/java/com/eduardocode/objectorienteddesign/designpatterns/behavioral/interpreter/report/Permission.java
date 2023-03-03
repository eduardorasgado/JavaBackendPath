package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.report;

public class Permission implements PermissionExpression {
    private final String permission;

    public Permission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean interpret(User user) {
        return user.hasPermission(permission);
    }

    @Override
    public String toString() {
        return permission;
    }
}
