package com.eduardocode.objectorienteddesign.designpatterns.structural.composite.shapeeditorgui;

import java.awt.*;

public class ImageEditor {
    private EditorCanvas canvas;
    private CompoundShape allShapes = new CompoundShape();

    public void loadShapes(Shape... shapes) {
    }

    private class EditorCanvas extends Canvas {
    }
}
