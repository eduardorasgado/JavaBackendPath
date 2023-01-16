package com.eduardocode.designpatterns.structural.composite.frames;

public class FramesDemo {

    public static void main(String[] args) {
        Frame frame = new Frame();

        frame.add(new Rectangle());
        frame.add(new Circle());

        Frame innerFrame = new Frame();
        frame.add(innerFrame);

        innerFrame.add(new Rectangle());

        frame.render();
    }
}
