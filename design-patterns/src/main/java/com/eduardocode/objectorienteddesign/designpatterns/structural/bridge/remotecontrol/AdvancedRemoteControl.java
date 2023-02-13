package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.remotecontrol;

public class AdvancedRemoteControl extends BasicRemoteControl {
    private int backupVolume;
    private boolean deviceMuted;

    public AdvancedRemoteControl(Device device) {
        super(device);
        backupVolume = 0;
        deviceMuted = false;
    }

    public void mute() {
        System.out.println("Remote: mute");
        if(isDeviceMuted()) {
            device.setVolume(getBackupVolume());
        }
        else {
            setBackupVolume(device.getVolume());
            device.setVolume(0);

        }

        toggleDeviceMuted();
    }

    private int getBackupVolume() {
        return backupVolume;
    }

    private void setBackupVolume(int backupVolume) {
        this.backupVolume = backupVolume;
    }

    private boolean isDeviceMuted() {
        return deviceMuted;
    }

    private void setDeviceMuted(boolean deviceMuted) {
        this.deviceMuted = deviceMuted;
    }

    private void toggleDeviceMuted() {
        setDeviceMuted(!isDeviceMuted());
    }
}
