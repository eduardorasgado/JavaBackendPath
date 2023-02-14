package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.archiver;

public class ArchiverFactory {

    /*
    Default Factory method implementation
     */
    public Archiver getArchiver() {
        return new ZipArchiver();
    }
}
