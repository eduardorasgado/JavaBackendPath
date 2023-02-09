package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.dependencyinversion.before;

public class TextFormatter implements Formatter {

    public String format(Message message){
        return message.getTimestamp() + ": " + message.getMsg();
    }
}