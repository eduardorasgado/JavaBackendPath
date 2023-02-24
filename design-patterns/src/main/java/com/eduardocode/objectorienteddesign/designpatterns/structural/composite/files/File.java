package com.eduardocode.objectorienteddesign.designpatterns.structural.composite.files;

public abstract class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void getPermissions();
    public abstract void setPermissions(String permissions);
}
