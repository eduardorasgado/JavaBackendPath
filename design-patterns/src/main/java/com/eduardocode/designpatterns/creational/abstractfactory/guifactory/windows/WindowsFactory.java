package com.eduardocode.designpatterns.creational.abstractfactory.guifactory.windows;

import com.eduardocode.designpatterns.creational.abstractfactory.guifactory.Button;
import com.eduardocode.designpatterns.creational.abstractfactory.guifactory.GUIFactory;
import com.eduardocode.designpatterns.creational.abstractfactory.guifactory.TextField;

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
