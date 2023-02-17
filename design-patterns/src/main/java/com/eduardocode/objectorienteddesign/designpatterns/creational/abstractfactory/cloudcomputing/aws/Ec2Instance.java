package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.aws;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.Instance;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.Storage;

public class Ec2Instance implements Instance {

    public Ec2Instance() {
        System.out.println("EC2 instance created");
    }

    @Override
    public void start() {
        System.out.println("EC2 instance started");
    }

    @Override
    public void attachStorage(Storage storage) {
        System.out.println("Attached " + storage + " to EC2 Instance");
    }

    @Override
    public void stop() {
        System.out.println("EC2 Instance stopped");
    }

    @Override
    public String toString() {
        return "Ec2Instance{}";
    }
}
