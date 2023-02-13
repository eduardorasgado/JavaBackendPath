package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.oswidgets;

import java.util.ArrayList;

public class MacOsWidgetFactory implements AbstractWidgetFactory {
    @Override
    public Window createWindow() {
        return new MacOsWindow();
    }

    @Override
    public Scroll createScroll() {
        return new MacOsScroll();
    }

    @Override
    public ArrayList<Button> createNavigationButtons() {
        return new ArrayList<>() {
            {
                add(new MacOsButton("Close"));
                add(new MacOsButton("Expand"));
                add(new MacOsButton("Back"));
            }
        };
    }
}
