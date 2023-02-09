package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.dependencyinversion.before;

public interface Formatter {

    public String format(Message message) throws FormatException;
}

