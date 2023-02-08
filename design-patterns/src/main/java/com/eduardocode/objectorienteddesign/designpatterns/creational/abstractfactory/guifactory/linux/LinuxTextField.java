package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.guifactory.linux;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.guifactory.TextField;

public class LinuxTextField implements TextField {

    @Override
    public void paint() {
        System.out.println("Linux Textfield");
    }
}
