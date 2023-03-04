package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.javafxui;

import javafx.scene.control.Label;

public class CustomLabel extends Label implements UIControl {

	private final UiMediator mediator;

	public CustomLabel(UiMediator mediator) {
		this.mediator = mediator;
		this.setMinWidth(100);
		this.setText("Label");
		mediator.register(this);
	}

	@Override
	public void controlChanged(UIControl control) {
		setText(control.getControlValue());
	}

	@Override
	public String getControlValue() {
		return getText();
	}

	@Override
	public String getControlName() {
		return "Label";
	}
}
