package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.document;

public class DocumentDemo {

    public static void main(String[] args) {
        Document document = new Document();
        document.addText("Arial", 12, "Hello World");
        document.addText("Arial", 14, "Hello World");
        document.addText("Arial", 12, "Hello World");
    }
}
