package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.forest;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    private static final Map<String, TreeType> types;

    static {
        types = new HashMap<>();
    }

    public TreeTypeFactory() {}

    public static TreeType getTreeType(String name, Color color, String details) {
        if(types.containsKey(name)) {
            return types.get(name);
        }

        TreeType newType = new TreeType(name, color, details);
        types.put(name, newType);

        return newType;
    }
}
