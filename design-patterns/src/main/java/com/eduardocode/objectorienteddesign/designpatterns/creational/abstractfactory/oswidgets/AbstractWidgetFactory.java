package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.oswidgets;

import java.util.List;

public interface AbstractWidgetFactory {

    Window createWindow();

    Scroll createScroll();

    List<Button> createNavigationButtons();
}
