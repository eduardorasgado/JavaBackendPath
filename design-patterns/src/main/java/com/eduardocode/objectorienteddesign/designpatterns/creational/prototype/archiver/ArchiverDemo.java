package com.eduardocode.objectorienteddesign.designpatterns.creational.prototype.archiver;

import java.io.File;

public class ArchiverDemo {

    public static void main(String[] args) {
        Archiver zipArchiver = ArchiverFactory.getPrototypeForType(ArchiveType.ZIP);
        Archiver rarArchiver = ArchiverFactory.getPrototypeForType(ArchiveType.RAR);

        zipArchiver.archive(new File(""));
        rarArchiver.archive(new File(""));
    }
}
