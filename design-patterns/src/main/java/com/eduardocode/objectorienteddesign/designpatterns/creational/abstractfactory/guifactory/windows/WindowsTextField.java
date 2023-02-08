package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.guifactory.windows;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.guifactory.TextField;

public class WindowsTextField implements TextField {

    @Override
    public void paint() {
        System.out.println("Windows Textfield");
    }
}
