package com.eduardocode.designpatterns.structural.facade.computer;

public class Computer {
    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }


    public void start() {
        cpu.freeze();
        memory.load(0, hardDrive.read(0, 0));
        cpu.execute();
    }
}
