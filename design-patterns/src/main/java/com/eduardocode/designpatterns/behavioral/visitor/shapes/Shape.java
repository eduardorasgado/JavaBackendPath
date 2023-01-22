package com.eduardocode.designpatterns.behavioral.visitor.shapes;

public interface Shape {
    String getName();
    String accept(ExportVisitor visitor);
}
