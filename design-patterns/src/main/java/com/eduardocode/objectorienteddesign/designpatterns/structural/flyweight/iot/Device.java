package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.iot;

public class Device {
    private String id;
    private DeviceModel model;
    private String location;

    public Device(String id, DeviceModel model, String location) {
        System.out.println("Device created...");
        this.id = id;
        this.model = model;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public DeviceModel getModel() {
        return model;
    }

    public String getLocation() {
        return location;
    }
}
