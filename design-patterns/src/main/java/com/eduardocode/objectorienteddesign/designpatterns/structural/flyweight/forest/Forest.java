package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.forest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {

    private List<Tree> trees;

    public Forest() {
        trees = new ArrayList<>();
    }

    public void plantTree(int x, int y, String name, Color color, String details) {
        TreeType type = TreeTypeFactory.getTreeType(name, color, details);
        Tree tree = new Tree(x, y, type);

        trees.add(tree);
    }

    @Override
    public void paint(Graphics graphics) {
        for(Tree tree : trees) {
            tree.draw(graphics);
        }
    }
}
