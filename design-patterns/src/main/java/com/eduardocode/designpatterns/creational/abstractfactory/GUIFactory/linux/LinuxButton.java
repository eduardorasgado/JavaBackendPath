package com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.linux;

import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.Button;

public class LinuxButton implements Button {

    @Override
    public void paint() {
        System.out.println("Linux button");
    }
}
