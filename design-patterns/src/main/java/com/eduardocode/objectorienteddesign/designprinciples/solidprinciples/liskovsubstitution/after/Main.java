package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.liskovsubstitution.after;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10, 20);
        Square square = new Square(10);

        logger.info("Testing for rectangle...");
        useRectangle(rectangle);
        getShapeArea(rectangle);


        logger.info("Testing for square...");
        useSquare(square);
        getShapeArea(square);
    }

    private static void useSquare(Square square) {
        square.setSide(10);

        assert square.getSide() == 10 : "Side not equals to 10";
    }

    private static void useRectangle(Rectangle rectangle) {
        rectangle.setHeight(20);
        rectangle.setWidth(10);

        assert rectangle.getHeight() == 20 : "Height not equals to 20";
        assert rectangle.getWidth() == 10 : "Width not equals to 10";
    }

    private static void getShapeArea(Shape shape) {
        logger.info("Shape area: " + shape.computeArea());
    }
}
