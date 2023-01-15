package com.eduardocode.designpatterns.creational.abstractfactory.guifactory;

public class App {
    private Button button;
    private TextField textField;

    public App(GUIFactory factory) {
        button = factory.createButton();
        textField = factory.createTextField();

        System.out.println("New app was created...");
    }

    public void render() {
        button.paint();
        textField.paint();
    }
}
