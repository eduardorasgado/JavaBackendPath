package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.guifactory;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.guifactory.linux.LinuxFactory;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.guifactory.windows.WindowsFactory;

public class GuiFactoryDemo {

    public static void main(String[] args) {
        App app = new App(new LinuxFactory());
        app.render();

        app = new App(new WindowsFactory());
        app.render();
    }
}
