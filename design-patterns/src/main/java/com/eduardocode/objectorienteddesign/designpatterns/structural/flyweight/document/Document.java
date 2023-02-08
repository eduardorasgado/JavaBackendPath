package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.document;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<Font> fonts;

    public Document() {
        this.fonts = new ArrayList<>();
    }

    public void addText(String fontName, int fontSize, String text) {
        Font font = FontFactory.getFont(fontName, fontSize);
        fonts.add(font);

        System.out.println("Added text: " + text + " with font: " + fontName + "-" + fontSize);
    }
}
