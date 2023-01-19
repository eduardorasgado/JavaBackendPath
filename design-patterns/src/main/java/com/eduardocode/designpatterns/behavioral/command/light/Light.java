package com.eduardocode.designpatterns.behavioral.command.light;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Light {

    private int intensity;
    private final int maxIntensity = 100;
    private final Map<IntensityAction, Supplier<Integer>> intensityActionMap;

    public Light() {
        this.intensity = maxIntensity;

        intensityActionMap = new HashMap<>();
        intensityActionMap.put(IntensityAction.RAISE, () -> Math.min(intensity + 10, maxIntensity + 1));
        intensityActionMap.put(IntensityAction.LOWER, () -> Math.max(intensity - 10, -1));
    }

    public enum IntensityAction {
        RAISE,
        LOWER;
    }

    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }

    public void raiseIntensity() {
        updateIntensity(IntensityAction.RAISE);
        System.out.println("New intensity: " + intensity);
    }

    public void lowerIntensity() {
        updateIntensity(IntensityAction.LOWER);
        System.out.println("New intensity: " + intensity);
    }

    private void updateIntensity(IntensityAction intensityAction) {
        intensity = intensityActionMap.get(intensityAction).get();
    }
}
