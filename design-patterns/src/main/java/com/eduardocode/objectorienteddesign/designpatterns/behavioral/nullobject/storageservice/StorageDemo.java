package com.eduardocode.objectorienteddesign.designpatterns.behavioral.nullobject.storage;

import java.io.File;

public class StorageDemo {

    public static void main(String[] args) {
        String filename = ("src.main.java." + StorageDemo.class.getPackageName() + ".custom-report")
                .replace(".", File.separator);

        //StorageService storageService = new StorageService();
        StorageService storageService = new NullStorageService();

        ComplexService service = new ComplexService(filename, storageService);

        service.generateReport();
    }
}
