package com.eduardocode.designpatterns.creational.abstractfactory.guifactory.linux;

import com.eduardocode.designpatterns.creational.abstractfactory.guifactory.Button;

public class LinuxButton implements Button {

    @Override
    public void paint() {
        System.out.println("Linux button");
    }
}
