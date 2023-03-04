package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.javafxui;

import javafx.scene.control.Slider;

public class CustomSlider extends Slider implements UIControl {

	private final UiMediator mediator;
	private boolean mediatedUpdate;

	public CustomSlider(UiMediator mediator) {
		this.mediator = mediator;
		setMin(0);
		setMax(50);
		setBlockIncrement(5);
		mediator.register(this);

		addListener();
	}

    private void addListener() {
        valueProperty().addListener((v,o,n) ->{
            if(!mediatedUpdate) {
                mediator.valueChanged(this);
            }
        });
    }

    @Override
	public void controlChanged(UIControl control) {
		mediatedUpdate = true;
		setValue(Double.valueOf(control.getControlValue()));
		mediatedUpdate = false;
	}

    @Override
    public String getControlValue() {
        return Double.toString(getValue());
    }

	@Override
	public String getControlName() {
		return "CustomSlider";
	}
}
