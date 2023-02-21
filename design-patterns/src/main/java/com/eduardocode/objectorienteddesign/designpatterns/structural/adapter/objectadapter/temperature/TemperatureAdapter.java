package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.objectadapter.temperature;

public class TemperatureAdapter implements TemperatureConverter {
    private KelvinConverter kelvinConverter;
    public TemperatureAdapter(KelvinConverter kelvinConverter) {
        this.kelvinConverter = kelvinConverter;
    }

    @Override
    public double convertFahrenheitToCelsius(double fahrenheit) {
        double kelvin = ((fahrenheit - 32)/1.8) + 273.15;
        return kelvinConverter.convertKelvinToCelsius(kelvin);
    }

    @Override
    public double convertCelsiusToFahrenheit(double celsius) {
        return 1.8 * (kelvinConverter.convertCelsiusToKelvin(celsius) - 273.15) + 32;
    }
}
