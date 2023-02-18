package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.document;

public class InModerationState extends DocumentState {

    public static final String ADMIN_ROLE = "ADMIN_ROLE";
    public static final String CONTENT_CREATOR_ROLE = "CONTENT_CREATOR_ROLE";

    public InModerationState(Document document) {
        super(document);
    }

    @Override
    public void publish(User user) {
        if(user.getRoleName().equals(ADMIN_ROLE)) {
            Document document = getDocument();
            document.setState(new PublishedState(getDocument()));

            document.setModeratedBy(user.getUsername());
            document.setPublishedBy(user.getUsername());

            System.out.println("Document is published");
        }
        else {
            System.out.println("You are not admin and cant publish content.");
        }
    }

    @Override
    public String toString() {
        return "InModerationState{}";
    }
}
