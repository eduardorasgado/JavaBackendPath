package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.archiver;

import java.io.File;

public class ZipArchiver implements Archiver {

    /*
    Default implementation
     */
    public void archive(File file) {
        System.out.println("Archiving to default ZIP file...");
    }
}
