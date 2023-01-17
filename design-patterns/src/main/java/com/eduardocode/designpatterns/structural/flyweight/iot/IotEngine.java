package com.eduardocode.designpatterns.structural.flyweight.iot;

import java.util.ArrayList;
import java.util.List;

public class IotEngine {

    private List<Device> devices;

    public IotEngine() {
        this.devices = new ArrayList<>();
    }

    public void addDevice(String id, DeviceType deviceType, String location) {
        DeviceModel model = DeviceModelFactory.getDeviceModel(deviceType);
        devices.add(new Device(id, model, location));

        System.out.println("Added device: " + id + " model: " + model.toString() + " at location: " + location);
    }
}
