package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.dependencyinversion.after;

public interface Formatter {

    public String format(Message message) throws FormatException;
}

