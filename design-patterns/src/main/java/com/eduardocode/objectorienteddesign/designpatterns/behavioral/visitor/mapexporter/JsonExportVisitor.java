package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.mapexporter;

public class JsonExportVisitor extends ExportVisitor {
    private final String format;

    public JsonExportVisitor() {
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
        System.out.println(getClassName() + " is exporting a private Building to " + format);
    }

    @Override
    public void visit(IndustrialBuilding industrialBuilding) {
        System.out.println(getClassName() + " is exporting an industrial building to " + format);
    }
}
