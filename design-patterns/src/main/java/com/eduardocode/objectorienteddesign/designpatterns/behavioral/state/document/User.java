package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.document;

public class User {
    private String roleName;
    private String username;

    public User(String roleName, String username) {
        this.roleName = roleName;
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getUsername() {
        return username;
    }
}
