package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.archiver;

public class RarArchiverFactory extends ArchiverFactory {

    @Override
    public Archiver getArchiver() {
        return new RarArchiver();
    }
}
