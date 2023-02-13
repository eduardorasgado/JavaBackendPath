package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.archiver;

import java.io.File;

public class ZipArchiver implements Archiver {

    @Override
    public void archive(File file) {
        System.out.println("Archiving to ZIP file...");
    }
}
