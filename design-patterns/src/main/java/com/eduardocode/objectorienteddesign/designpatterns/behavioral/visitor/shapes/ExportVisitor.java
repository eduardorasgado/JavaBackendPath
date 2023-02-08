package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.shapes;

public interface ExportVisitor {
    String visit(CompoundShape compoundShape);

    String visit(Rectangle rectangle);

    String visit(Circle circle);
}
