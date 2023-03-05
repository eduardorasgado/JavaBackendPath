package com.eduardocode.objectorienteddesign.designpatterns.behavioral.iterator.color;

public class ColorDemo {

    public static void main(String[] args) {
        Iterator<ThemeColor> iterator = ThemeColor.getIterator();

        while (iterator.hasNext()) {
            System.out.println("color: " + iterator.next());
        }
    }
}
