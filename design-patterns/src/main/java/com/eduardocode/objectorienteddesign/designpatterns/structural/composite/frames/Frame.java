package com.eduardocode.objectorienteddesign.designpatterns.structural.composite.frames;

import java.util.ArrayList;
import java.util.List;

public class Frame implements Shape {
    List<Shape> shapes;

    public Frame() {
        this.shapes = new ArrayList<>();
    }

    public void add(Shape shape) {
        if(shapes != null && !shapes.contains(shape)) {
            shapes.add(shape);
        }
    }

    @Override
    public void render() {
        System.out.println("Frame content: ");

        for(Shape shape : shapes) {
            shape.render();
        }

        System.out.println("End Frame");
    }
}
