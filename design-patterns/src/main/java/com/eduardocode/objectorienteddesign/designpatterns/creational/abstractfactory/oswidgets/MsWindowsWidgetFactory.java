package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.oswidgets;

import java.util.ArrayList;

public class MsWindowsWidgetFactory implements AbstractWidgetFactory {
    @Override
    public Window createWindow() {
        return new MsWindow();
    }

    @Override
    public Scroll createScroll() {
        return new MsScroll();
    }

    @Override
    public ArrayList<Button> createNavigationButtons() {
        return new ArrayList<>() {
            {
                add(new MsButton("Close"));
                add(new MsButton("Expand"));
                add(new MsButton("Collapse"));
                add(new MsButton("Back"));
            }
        };
    }
}
