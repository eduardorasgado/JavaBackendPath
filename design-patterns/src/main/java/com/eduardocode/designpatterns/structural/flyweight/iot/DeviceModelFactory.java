package com.eduardocode.designpatterns.structural.flyweight.iot;

import java.util.HashMap;
import java.util.Map;

public class DeviceModelFactory {
    private static Map<DeviceType, DeviceModel> deviceModels = new HashMap<>();

    public static DeviceModel getDeviceModel(DeviceType deviceType) {
        if(deviceModels.containsKey(deviceType)) {
           return deviceModels.get(deviceType);
        }

        DeviceModel deviceModel = new DeviceModel(deviceType);
        deviceModels.put(deviceType, deviceModel);

        return deviceModel;
    }
}
