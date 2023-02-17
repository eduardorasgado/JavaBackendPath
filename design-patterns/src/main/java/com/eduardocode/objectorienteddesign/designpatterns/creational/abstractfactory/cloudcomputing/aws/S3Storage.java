package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.aws;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing.Storage;

public class S3Storage implements Storage {

    public S3Storage(int capacityInMib) {
        System.out.println("Allocated " + capacityInMib + " on S3");
    }

    @Override
    public String getId() {
        return "AWS-S55";
    }

    @Override
    public String toString() {
        return "S3 Storage{}";
    }
}
