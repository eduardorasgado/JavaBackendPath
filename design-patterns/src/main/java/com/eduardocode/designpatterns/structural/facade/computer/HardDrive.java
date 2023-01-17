package com.eduardocode.designpatterns.structural.facade.computer;

public class HardDrive {
    public byte[] read(int lba, int size) {
        System.out.println("Reading data from the hard drive...");
        return new byte[0];
    }
}
