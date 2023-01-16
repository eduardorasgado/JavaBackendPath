package com.eduardocode.designpatterns.structural.composite.levels;

public class SimpleDemo {

    public static void main(String[] args) {
        Composite composite = new Composite();
        composite.addChild(new Leaf("File 1"));
        composite.addChild(new Leaf("File 2"));

        Composite subComposite = new Composite();
        composite.addChild(subComposite);

        subComposite.addChild(new Leaf("File 3"));
        subComposite.addChild(new Leaf("File 4"));



        Composite subComposite2 = new Composite();
        composite.addChild(subComposite2);

        subComposite2.addChild(new Leaf("File 5"));

        Composite subComposite3 = new Composite();
        subComposite2.addChild(subComposite3);

        subComposite3.addChild(new Leaf("File 6"));
        subComposite3.addChild(new Leaf("File 7"));

        composite.print();
    }
}
