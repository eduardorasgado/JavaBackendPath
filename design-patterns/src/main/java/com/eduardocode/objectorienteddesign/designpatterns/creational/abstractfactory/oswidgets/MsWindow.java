package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.oswidgets;

public class MsWindow implements Window {
    String title;

    public MsWindow() {
        this.title = null;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}
