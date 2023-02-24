package com.eduardocode.objectorienteddesign.designpatterns.structural.composite.files;

public class BinaryFile extends File{

    private String permissions;

    public BinaryFile(String name) {
        super(name);
    }

    @Override
    public void getPermissions() {
        System.out.println("File " + getName() + ", permissions: " + permissions);
    }

    @Override
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
