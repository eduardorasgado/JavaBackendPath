package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.document;

public class DraftState extends DocumentState {

    public DraftState(Document document) {
        super(document);
    }

    @Override
    public void publish(User user) {
        getDocument().setCreatedBy(user.getUsername());
        getDocument().setState(new InModerationState(getDocument()));

        System.out.println("Document is sent to moderation");
    }

    @Override
    public String toString() {
        return "DraftState{}";
    }
}
