package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.forest;

import java.awt.*;

public class ForestDemo {

    public static void main(String[] args) {
        int CANVAS_SIZE = 1000;
        int TREES_TO_DRAW = 10000;
        int TREE_TYPES = 2;

        Forest forest = new Forest();

        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            forest.plantTree(getRandomWithinZeroAndUpper(CANVAS_SIZE), getRandomWithinZeroAndUpper(CANVAS_SIZE),
                    "Summer Oak", Color.GREEN, "Oak texture stub");

            forest.plantTree(getRandomWithinZeroAndUpper(CANVAS_SIZE), getRandomWithinZeroAndUpper(CANVAS_SIZE),
                    "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
        }

        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);

        printForestInsights(TREES_TO_DRAW, TREE_TYPES);
    }

    private static void printForestInsights(int treesToDraw, int treeTypes) {
        System.out.println(treesToDraw + " trees drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + treesToDraw);
        System.out.println("+ TreeTypes size (~30 bytes) * " + treeTypes + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((treesToDraw * 8 + treeTypes * 30) / 1024 ) +
                "KB (instead of " + ((treesToDraw * 38) / 1024 ) + "KB)");
    }

    private static int getRandomWithinZeroAndUpper(int upperLimit) {
        return random(0, upperLimit);
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
