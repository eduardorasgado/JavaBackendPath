package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.aws.AwsResourceFactory;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.gcp.GoogleResourceFactory;

public class CloudComputingDemo {

    private ResourceFactory factory;

    public CloudComputingDemo(ResourceFactory factory) {
        this.factory = factory;
    }

    public Instance createServer(Instance.Capacity capacity, int storageMib) {
        Instance instance = factory.createInstance(capacity);
        Storage storage = factory.createStorage(storageMib);

        instance.attachStorage(storage);
        return instance;
    }

    public static void main(String[] args) {
        CloudComputingDemo app = new CloudComputingDemo(new AwsResourceFactory());
        Instance server = app.createServer(Instance.Capacity.LARGE, 4096);

        System.out.println(server);

        server.start();
        server.stop();

        app = new CloudComputingDemo(new GoogleResourceFactory());
        server = app.createServer(Instance.Capacity.MICRO, 1024);

        System.out.println(server);

        server.start();
        server.stop();
    }
}
