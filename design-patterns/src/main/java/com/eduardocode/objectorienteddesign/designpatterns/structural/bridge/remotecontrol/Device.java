package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.remotecontrol;

public interface Device {
    boolean isEnabled();

    public void enable();

    public void disable();

    public int getVolume();

    public void setVolume(int percent);

    public int getChannel();

    public void setChannel(int channel);

    public void printStatus();

}
