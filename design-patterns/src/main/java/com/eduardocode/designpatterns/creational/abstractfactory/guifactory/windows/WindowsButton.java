package com.eduardocode.designpatterns.creational.abstractfactory.guifactory.windows;

import com.eduardocode.designpatterns.creational.abstractfactory.guifactory.Button;

public class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("Windows button");
    }
}
