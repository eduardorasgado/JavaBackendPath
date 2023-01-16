package com.eduardocode.designpatterns.structural.adapter.temperature;

public class KelvinConverter {
    public double convertKelvinToCelsius(double kelvin) {
        return kelvin -273.15;
    }

    public double convertCelsiusToKelvin(double celsius) {
        return celsius+ 273.15;
    }
}
