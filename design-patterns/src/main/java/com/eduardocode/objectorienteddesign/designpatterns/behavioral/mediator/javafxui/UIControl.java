package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.javafxui;

public interface UIControl {
    void controlChanged(UIControl control);

    String getControlValue();

    String getControlName();
}
