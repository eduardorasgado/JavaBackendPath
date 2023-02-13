package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.archiver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ArchiverFactory {
    private static final Map<ArchiveType, Supplier<Archiver>> archiverMap = new HashMap<>();

    static {
        archiverMap.put(ArchiveType.RAR, RarArchiver::new);
        archiverMap.put(ArchiveType.ZIP, ZipArchiver::new);
    }
    public static Archiver getArchiver(ArchiveType type) {
        return archiverMap.get(type).get();
    }
}
