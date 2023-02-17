package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.gcp;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.Instance;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.ResourceFactory;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.Storage;

public class GoogleResourceFactory implements ResourceFactory {
    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new GoogleComputeEngineInstance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new GoogleCloudStorage(capMib);
    }
}
