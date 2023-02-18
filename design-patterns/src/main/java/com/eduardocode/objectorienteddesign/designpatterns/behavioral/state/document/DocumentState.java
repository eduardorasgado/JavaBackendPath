package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.document;

public abstract class DocumentState implements State {
    private Document document;

    public DocumentState(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }
}
