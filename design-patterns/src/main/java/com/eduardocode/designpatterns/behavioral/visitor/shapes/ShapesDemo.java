package com.eduardocode.designpatterns.behavioral.visitor.shapes;

public class ShapesDemo {

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(4);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(12);

        CompoundShape compoundShape = new CompoundShape();
        compoundShape.setShapes("rectangle and circle");

        ShapeApplication app = new ShapeApplication();

        app.addShape(circle);
        app.addShape(rectangle);
        app.addShape(compoundShape);

        ExportVisitor xmlExportVisitor = new XMLExportVisitor();
        app.setExporter(xmlExportVisitor);
        app.exportAll();

        System.out.println();

        ExportVisitor jsonExportVisitor = new JsonExportVisitor();
        app.setExporter(jsonExportVisitor);
        app.exportAll();
    }
}
