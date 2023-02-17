package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.gcp;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.Instance;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.Storage;

import java.sql.SQLOutput;

public class GoogleComputeEngineInstance implements Instance {

    public GoogleComputeEngineInstance() {
        System.out.println("Created Google Compute Engine instance");
    }

    @Override
    public void start() {
        System.out.println("Comute engine instance started");
    }

    @Override
    public void attachStorage(Storage storage) {
        System.out.println("Attached " + storage + " to Compute engine instance");
    }

    @Override
    public void stop() {
        System.out.println("Compute Engine instance stopped");
    }

    @Override
    public String toString() {
        return "GoogleComputeEngineInstance{}";
    }
}
