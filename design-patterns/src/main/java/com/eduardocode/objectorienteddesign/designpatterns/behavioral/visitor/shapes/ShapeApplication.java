package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.shapes;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class ShapeApplication {
    private ExportVisitor exportVisitor;
    private final List<Shape> shapes;

    public ShapeApplication() {
        this.shapes = new ArrayList<>();
    }

    public void setExporter(ExportVisitor exportVisitor) {
        this.exportVisitor =exportVisitor;
    }

    public void addShape(Shape shape) {
        if(!shapes.contains(shape)) {
            shapes.add(shape);
        }
    }

    public void exportAll() {
        if(isNull(exportVisitor)) {
            throw new IllegalStateException();
        } else {
            for (Shape shape: shapes) {
                System.out.println(shape.accept(exportVisitor));
            }
        }
    }
}
