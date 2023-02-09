package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.dependencyinversion.after;

public class TextFormatter implements Formatter {

    public String format(Message message){
        return message.getTimestamp() + ": " + message.getMsg();
    }
}