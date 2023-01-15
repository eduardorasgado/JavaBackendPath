package com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.linux;

import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.TextField;

public class LinuxTextField implements TextField {

    @Override
    public void paint() {
        System.out.println("Linux Textfield");
    }
}
