package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.document;

import static com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.document.InModerationState.ADMIN_ROLE;
import static com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.document.InModerationState.CONTENT_CREATOR_ROLE;

public class DocumentDemo {

    public static void main(String[] args) {
        Document document = new Document();
        User adminUser = new User(ADMIN_ROLE, "EDUARDO_ADMIN");
        User contentCreatorUser = new User(CONTENT_CREATOR_ROLE, "EDUARDO_CC");

        document.printStatus();

        document.publish(contentCreatorUser);
        document.printStatus();

        document.publish(contentCreatorUser);
        document.printStatus();

        document.publish(adminUser);
        document.printStatus();

        document.publish(adminUser);
    }
}
