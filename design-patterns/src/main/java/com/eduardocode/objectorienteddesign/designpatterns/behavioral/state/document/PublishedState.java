package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.document;

public class PublishedState extends DocumentState {
    public PublishedState(Document document) {
        super(document);
    }

    @Override
    public void publish(User user) {
        System.out.println("Document is already published.");
    }

    @Override
    public String toString() {
        return "PublishedState{}";
    }
}
