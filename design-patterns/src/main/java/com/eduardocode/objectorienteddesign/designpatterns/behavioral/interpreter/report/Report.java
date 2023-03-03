package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.report;

public class Report {
    private final String name;
    //"NOT ADMIN", "FINANCE_USER AND ADMIN"
    private final String permission;

    public Report(String name, String permissions) {
        this.name = name;
        this.permission = permissions;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }
}
