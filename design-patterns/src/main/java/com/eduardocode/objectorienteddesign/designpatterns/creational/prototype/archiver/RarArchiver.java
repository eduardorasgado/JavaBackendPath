package com.eduardocode.objectorienteddesign.designpatterns.creational.prototype.archiver;

import org.apache.commons.lang3.SerializationUtils;

import java.io.File;
import java.io.Serializable;

public class RarArchiver implements Archiver, Serializable {

    @Override
    public void archive(File file) {
        System.out.println("File was archived as a RAR file.");
    }

    /*
    In terms of performance, using SerializationUtils.clone() to clone composed objects can be relatively slow compared
    to other cloning methods, as it involves serializing and deserializing the objects. However, it can be a convenient
    and effective way to create deep copies of complex object graphs that contain references to other objects, and it
    doesn't require you to write custom code to handle each individual field of the object.

    It's also important to note that the SerializationUtils.clone() method requires that all objects in the object graph
    be Serializable. If any object in the graph is not Serializable, the method will throw a java.io.NotSerializableException.
     */
    @Override
    public Archiver clone() {
        return SerializationUtils.clone(this);
    }
}
