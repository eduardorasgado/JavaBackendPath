package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.gcp;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.Storage;


public class GoogleCloudStorage implements Storage {

    public GoogleCloudStorage(int capacityInMib) {
        System.out.println("Allocated " + capacityInMib + " on Google Cloud Storage");
    }

    @Override
    public String getId() {
        return "GCP-23LLN4LL";
    }

    @Override
    public String toString() {
        return "Google Cloud Storage{}";
    }
}
