package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.iot;

public class IotDemo {

    public static void main(String[] args) {
        IotEngine iot = new IotEngine();

        iot.addDevice("D1", DeviceType.Thermometer, "LivingRoom");
        iot.addDevice("D4", DeviceType.Camera, "Livingroom");

        iot.addDevice("D1", DeviceType.Thermometer, "Kitchen");
        iot.addDevice("D2", DeviceType.Camera, "Kitchen");

        iot.addDevice("D1", DeviceType.Thermometer, "Kitchen");
        iot.addDevice("D3", DeviceType.PIR, "Bedroom");


        iot.addDevice("D1", DeviceType.Thermometer, "Kitchen");
        iot.addDevice("D4", DeviceType.Camera, "Bathroom");
    }
}
