package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.report;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {
    private List<String> permissions;

    private String username;

    public User(String username, String... permissions) {
        this.username = username;
        this.permissions = new ArrayList<>();

        Stream.of(permissions).forEach(e->this.permissions.add(e.toLowerCase()));
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public String getUsername() {
        return username;
    }

    public boolean hasPermission(String permission) {
        return getPermissions().contains(permission);
    }
}
