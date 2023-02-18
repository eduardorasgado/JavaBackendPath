package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.texteditor;

public class TextWindow {
    private StringBuilder text;

    public TextWindow() {
        text = new StringBuilder();
    }

    public void write(String text) {
        this.text.append(text);
    }

    public PublicTextEditorState getSnapshot() {
        return new TextEditorState(text);
    }

    public void print() {
        System.out.println(text.toString());
    }

    private void setText(StringBuilder text) {
        this.text = text;
    }

    private static class TextEditorState implements PublicTextEditorState {
        private final StringBuilder text;

        private TextEditorState(StringBuilder text) {
            this.text = text;
        }

        @Override
        public void restore(TextWindow textWindow) {
            textWindow.setText(text);
        }
    }
}
