package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.javafxui;

import java.util.ArrayList;
import java.util.List;

public class UiMediator {
    List<UIControl> colleagues;

    public UiMediator() {
        colleagues = new ArrayList<>();
    }

    public void register(UIControl control) {
        if (!colleagues.contains(control)) {
            colleagues.add(control);
        }
    }

    public void valueChanged(UIControl control) {
        colleagues.stream()
                .filter(colleague -> !colleague.equals(control))
                .forEach(colleague -> colleague.controlChanged(control));
    }
}
