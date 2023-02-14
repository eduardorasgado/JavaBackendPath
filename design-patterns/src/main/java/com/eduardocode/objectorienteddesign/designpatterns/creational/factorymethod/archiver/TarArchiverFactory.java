package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.archiver;

public class TarArchiverFactory extends ArchiverFactory {

    @Override
    public Archiver getArchiver() {
        return new TarArchiver();
    }
}
