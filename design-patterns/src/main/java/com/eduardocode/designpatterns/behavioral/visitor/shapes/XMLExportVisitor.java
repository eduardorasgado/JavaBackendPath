package com.eduardocode.designpatterns.behavioral.visitor.shapes;

public class XMLExportVisitor implements ExportVisitor {
    @Override
    public String visit(CompoundShape compoundShape) {
        return "Exporting the " + compoundShape.getName() + " in a XML format including the shapes: " + compoundShape.getShapes();
    }

    @Override
    public String visit(Rectangle rectangle) {
        return "Exporting the " + rectangle.getName() + " in a XML format using the height: "
                + rectangle.getHeight() + " and width: " + rectangle.getWidth();
    }

    @Override
    public String visit(Circle circle) {
        return "Exporting the " + circle.getName() + " in a XML format using the radious: " + circle.getRadius();
    }
}
