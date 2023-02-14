package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.archiver;

import java.io.File;

public class ArchiverDemo {

    public static void main(String[] args) {
        testArchiverFactory(new ArchiverFactory());
        testArchiverFactory(new RarArchiverFactory());
        testArchiverFactory(new TarArchiverFactory());
    }

    private static void testArchiverFactory(ArchiverFactory archiverFactory) {
        Archiver archiver = archiverFactory.getArchiver();
        archiver.archive(new File(""));
    }
}
