package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.texteditor;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    List<PublicTextEditorState> history;

    public TextEditor() {
        history = new ArrayList<>();
    }

    public void save(TextWindow textWindow) {
        history.add(textWindow.getSnapshot());
    }

    private PublicTextEditorState getSnapshotByIndex(int index) {
        return history.get(index);
    }

    public void updateStateBySnapshotIndex(int index, TextWindow textWindow) {
        getSnapshotByIndex(index).restore(textWindow);
    }
}
