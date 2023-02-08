package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.document;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private static Map<String, Font> fonts = new HashMap<>();

    public static Font getFont(String fontName, int fontSize) {
        String key = fontName + "-" + fontSize;

        if(fonts.containsKey(key)) {
            return fonts.get(key);
        }

        Font font = new Font(fontName, fontSize);
        fonts.put(key, font);

        return font;
    }
}
