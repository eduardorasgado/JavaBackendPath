package com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.windows;

import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.Button;
import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.GUIFactory;
import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.TextField;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}
