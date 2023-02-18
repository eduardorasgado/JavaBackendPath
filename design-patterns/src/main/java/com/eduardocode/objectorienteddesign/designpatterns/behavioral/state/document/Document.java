package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.document;

public class Document {
    private State state;
    private String createdBy;
    private String moderatedBy;
    private String publishedBy;

    public Document() {
        state = new DraftState(this);
    }

    public void publish(User user) {
        state.publish(user);
    }

    public void printStatus() {
        System.out.println("===== Document Status =====");
        System.out.println("Created by: " + getCreatedBy());
        System.out.println("Moderated by: " + getModeratedBy());
        System.out.println("Published by: " + getPublishedBy());
        System.out.println("State: " + getState().toString());
        System.out.println("============================");
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModeratedBy() {
        return moderatedBy;
    }

    public void setModeratedBy(String moderatedBy) {
        this.moderatedBy = moderatedBy;
    }

    public String getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(String publishedBy) {
        this.publishedBy = publishedBy;
    }
}
