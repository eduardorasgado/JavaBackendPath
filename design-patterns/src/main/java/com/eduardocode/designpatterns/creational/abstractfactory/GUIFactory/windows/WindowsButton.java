package com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.windows;

import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.Button;

public class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("Windows button");
    }
}
