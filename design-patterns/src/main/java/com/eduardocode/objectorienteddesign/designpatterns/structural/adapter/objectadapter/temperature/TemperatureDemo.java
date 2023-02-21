package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.objectadapter.temperature;

public class TemperatureDemo {

    public static void main(String[] args) {
        TemperatureConverter celsiusConverter = new CelsiusConverter();
        TemperatureConverter kelvinAdapter = new TemperatureAdapter(new KelvinConverter());

        System.out.println("Celsius: " + celsiusConverter.convertFahrenheitToCelsius(100.0) + " C");
        System.out.println("Fahrenheit: " + celsiusConverter.convertCelsiusToFahrenheit(37.78) + " F");

        System.out.println("Celsius: " + kelvinAdapter.convertFahrenheitToCelsius(100.0) + " C");
        System.out.println("Fahrenheit: " + kelvinAdapter.convertCelsiusToFahrenheit(37.78) + " F");
    }
}
