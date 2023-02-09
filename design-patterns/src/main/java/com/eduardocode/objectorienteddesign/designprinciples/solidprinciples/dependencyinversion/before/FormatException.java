package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.dependencyinversion.before;

import java.io.IOException;

public class FormatException extends IOException {

    public FormatException(Exception cause) {
        super(cause);
    }
}
