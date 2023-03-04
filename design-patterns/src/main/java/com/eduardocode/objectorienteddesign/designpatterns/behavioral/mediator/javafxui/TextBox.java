package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.javafxui;

import javafx.scene.control.TextField;

public class TextBox extends TextField implements UIControl {

    private final UiMediator mediator;

    private boolean mediatedUpdate;

    public TextBox(UiMediator mediator) {
        this.mediator = mediator;
        mediatedUpdate = false;
        setText("Text Box");
        mediator.register(this);

        addListener();
    }

    private void addListener() {
        textProperty().addListener((observable, oldValue, newValue) -> {
            if(!mediatedUpdate) {
                mediator.valueChanged(this);
            }
        });
    }

    @Override
    public void controlChanged(UIControl control) {
        mediatedUpdate = true;
        setText(control.getControlValue());
        mediatedUpdate = false;
    }

    @Override
    public String getControlValue() {
        return getText();
    }

    @Override
    public String getControlName() {
        return "TextBox";
    }
}
