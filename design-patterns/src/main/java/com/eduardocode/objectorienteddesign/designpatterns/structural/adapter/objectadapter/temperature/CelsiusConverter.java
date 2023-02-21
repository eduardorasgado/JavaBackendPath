package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.objectadapter.temperature;

public class CelsiusConverter implements TemperatureConverter {
    @Override
    public double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 ;
    }

    @Override
    public double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
