package com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.linux;

import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.Button;
import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.GUIFactory;
import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.TextField;

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
