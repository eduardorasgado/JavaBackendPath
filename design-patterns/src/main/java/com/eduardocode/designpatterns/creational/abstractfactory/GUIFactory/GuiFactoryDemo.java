package com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory;

import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.linux.LinuxFactory;
import com.eduardocode.designpatterns.creational.abstractfactory.GUIFactory.windows.WindowsFactory;

public class GuiFactoryDemo {

    public static void main(String[] args) {
        App app = new App(new LinuxFactory());
        app.render();

        app = new App(new WindowsFactory());
        app.render();
    }
}
