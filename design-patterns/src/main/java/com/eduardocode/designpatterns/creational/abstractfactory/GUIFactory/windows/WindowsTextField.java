package com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.windows;

import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.TextField;

public class WindowsTextField implements TextField {

    @Override
    public void paint() {
        System.out.println("Windows Textfield");
    }
}
