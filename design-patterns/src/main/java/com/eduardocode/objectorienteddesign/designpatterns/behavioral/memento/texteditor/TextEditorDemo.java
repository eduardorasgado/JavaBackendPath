package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.texteditor;

public class TextEditorDemo {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        TextWindow textWindow = new TextWindow();

        textWindow.write("This is the lesson about memento pattern" + System.lineSeparator());
        textWindow.write("Memento is a behavioral GoF pattern." + System.lineSeparator());

        textEditor.save(textWindow);
        textWindow.write("This is example of memento pattern implementation" + System.lineSeparator());
        textEditor.save(textWindow);

        textWindow.print();
        System.out.println("--------------------------------");
        textEditor.updateStateBySnapshotIndex(0, textWindow);

        textWindow.print();
        System.out.println("--------------------------------");
        textEditor.updateStateBySnapshotIndex(1, textWindow);

        textWindow.print();
    }
}
