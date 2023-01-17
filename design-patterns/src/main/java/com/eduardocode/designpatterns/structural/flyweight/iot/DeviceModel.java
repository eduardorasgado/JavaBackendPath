package com.eduardocode.designpatterns.structural.flyweight.iot;

public class DeviceModel {
    private DeviceType type;

    public DeviceModel(DeviceType type) {
        System.out.println("[Device Model] has been created");
        this.type = type;
    }

    public DeviceType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "DeviceModel{" +
                "type=" + type +
                '}';
    }
}
