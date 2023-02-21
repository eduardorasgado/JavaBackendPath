package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.objectadapter.temperature;

public class KelvinConverter {
    public double convertKelvinToCelsius(double kelvin) {
        return kelvin -273.15;
    }

    public double convertCelsiusToKelvin(double celsius) {
        return celsius+ 273.15;
    }
}
