package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.audioplayer;

import java.util.function.Consumer;

public class AdvancedButton extends BasicButton {

    private Consumer<ButtonAction> onDoubleClickFunction;

    public AdvancedButton(String name) {
        super(name);
    }

    public void onClick(Consumer<ButtonAction> consumer) {
        onClick(() -> consumer.accept(ButtonAction.CLICK));
    }

    public void onDoubleClick(Consumer<ButtonAction> consumer) {
        onDoubleClickFunction = consumer;
    }

    public void doubleClick() {
        onDoubleClickFunction.accept(ButtonAction.DOUBLE_CLICK);
    }
}
