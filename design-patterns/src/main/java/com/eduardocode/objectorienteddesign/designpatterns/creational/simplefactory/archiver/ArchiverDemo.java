package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.archiver;

import java.io.File;

public class ArchiverDemo {

    public static void main(String[] args) {
        Archiver archiver1 = ArchiverFactory.getArchiver(ArchiveType.ZIP);
        Archiver archiver2 = ArchiverFactory.getArchiver(ArchiveType.RAR);

        archiver1.archive(new File(""));
        archiver2.archive(new File(""));

        System.out.println(ArchiverFactory.getArchiver(ArchiveType.ZIP) == archiver1);
    }
}
