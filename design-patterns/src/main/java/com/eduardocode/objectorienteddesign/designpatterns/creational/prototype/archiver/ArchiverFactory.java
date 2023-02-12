package com.eduardocode.objectorienteddesign.designpatterns.creational.prototype.archiver;

import java.util.HashMap;
import java.util.Map;

public class ArchiverFactory {

    private static Map<ArchiveType, Archiver> prototypes = new HashMap<>();

    static {
        prototypes.put(ArchiveType.ZIP, new ZipArchiver());
        prototypes.put(ArchiveType.RAR, new RarArchiver());
    }

    public ArchiverFactory() {}

    public static Archiver getPrototypeForType(ArchiveType type) {
        return prototypes.get(type).clone();
    }
}
