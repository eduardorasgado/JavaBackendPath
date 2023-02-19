package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.mapexporter;

public class XMLExportVisitor extends ExportVisitor {
    private final String format;

    public XMLExportVisitor() {
        format = "JSON format";
    }

    @Override
    public void visit(Park park) {
        System.out.println(getClassName() + " is exporting a park to " + format);
    }

    @Override
    public void visit(ShoppingCenter shoppingCenter) {
        System.out.println(getClassName() + " is exporting a shopping center to " + format);
    }

    @Override
    public void visit(PrivateBuilding privateBuilding) {
        System.out.println(getClassName() + " is exporting a private building to " + format);
    }

    @Override
    public void visit(IndustrialBuilding industrialBuilding) {
        System.out.println(getClassName() + " is exporting an industrial building to " + format);
    }
}
