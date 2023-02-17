package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.aws;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.Instance;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.ResourceFactory;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.Storage;

public class AwsResourceFactory implements ResourceFactory {
    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new Ec2Instance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}
