package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.mapexporter;

public class MapExporterDemo {

    public static void main(String[] args) {
        GeoElement industrialBuilding = new IndustrialBuilding();
        GeoElement park = new Park();
        GeoElement privateBuilding = new PrivateBuilding();
        GeoElement shoppingCenter = new ShoppingCenter();

        ExportVisitor visitor = new XMLExportVisitor();
        visitor.export(industrialBuilding, park, privateBuilding, shoppingCenter);

        System.out.println("==================================================");

        visitor = new JsonExportVisitor();
        visitor.export(industrialBuilding, park, privateBuilding, shoppingCenter);
    }
}
