package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.temperature;

public interface TemperatureConverter {

    double convertFahrenheitToCelsius(double fahrenheit);

    double convertCelsiusToFahrenheit(double celsius);
}
