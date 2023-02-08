package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.shapes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ShapeFactory {

    private static final Map<ShapeType, Supplier<Shape>> shapeSupplierMap;

    public enum ShapeType {
        CIRCLE,
        SQUARE,
        RECTANGLE;
    }

    static {
        shapeSupplierMap = new HashMap<>();

        shapeSupplierMap.put(ShapeType.CIRCLE, Circle::new);
        shapeSupplierMap.put(ShapeType.SQUARE, Square::new);
        shapeSupplierMap.put(ShapeType.RECTANGLE, Rectangle::new);
    }

    public static Shape createShape(ShapeType type) {
        return shapeSupplierMap.get(type).get();
    }
}
