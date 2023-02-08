package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.document;

public class Font {
    public String fontName;
    public int fontSize;

    public Font(String fontName, int fontSize) {
        System.out.println("New font stored in the JVM");

        this.fontName = fontName;
        this.fontSize = fontSize;
    }
}
