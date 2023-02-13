package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.remotecontrol;

public class Tv implements Device {
    private boolean enabled;
    private int volume;
    private int channel;

    private final int maxChannel;

    public Tv() {
        this.enabled = false;
        volume = 30;
        channel = 1;
        maxChannel = 10;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void enable() {
        System.out.println("Tv is turning on....");
        setEnabled(true);
    }

    @Override
    public void disable() {
        System.out.println("Tv is turning off...");
        setEnabled(false);
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if(percent > 100) {
            percent = 100;
        }
        else if(percent < 0) {
            percent = 0;
        }

        volume = percent;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        if(channel > maxChannel) {
            channel = 1;
        }
        else if(channel < 1) {
            channel = maxChannel;
        }
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm TV set.");
        System.out.println("| I'm " + (enabled ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }
}
