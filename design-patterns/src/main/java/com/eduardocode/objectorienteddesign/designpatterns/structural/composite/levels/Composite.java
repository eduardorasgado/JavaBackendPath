package com.eduardocode.objectorienteddesign.designpatterns.structural.composite.levels;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Level implements Component {
    List<Component> children;

    public Composite() {
        super(1);
        this.children = new ArrayList<>();
    }

    public void addChild(Component component) {
        ((Level) component).setLevel(getLevel() + 1);

        if(!children.contains(component)) {
            children.add(component);
        }
    }

    public void removeChild(int childIndex){
        if(!children.isEmpty() && childIndex < children.size()) {
            children.remove(childIndex);
        }
    }

    @Override
    public void print() {
        printLevel();
        System.out.println("Composite children: ");

        for(Component child : children) {
            child.print();
        }

        printLevel();
        System.out.println("End Composite children");
    }
}
