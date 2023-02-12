package com.eduardocode.objectorienteddesign.designpatterns.creational.prototype.archiver;

import java.io.File;

public interface Archiver extends Prototype<Archiver> {

    void archive(File file);
}
