package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.oswidgets;

import java.util.List;

public class GuiBuilder {
    public void buildWindow(AbstractWidgetFactory widgetFactory) {
        System.out.println("Building os with: " + widgetFactory.getClass().getSimpleName());

        Window window = widgetFactory.createWindow();
        System.out.println(window.getClass().getSimpleName());
        window.setTitle("New Window");

        Scroll scroll = widgetFactory.createScroll();
        System.out.println(scroll.getClass().getSimpleName());

        List<Button> navButtons = widgetFactory.createNavigationButtons();
        System.out.println(navButtons.get(0).getClass().getSimpleName());
    }
}
