package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.guifactory.linux;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.guifactory.Button;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.guifactory.GUIFactory;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.guifactory.TextField;

public class LinuxFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextField createTextField() {
        return new LinuxTextField();
    }
}
