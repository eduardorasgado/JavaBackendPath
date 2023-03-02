package com.eduardocode.objectorienteddesign.designpatterns.behavioral.command.emailservice;

public class EmailWebService {

    public void addMember(String contact, String contactGroup) {
        System.out.println("Added "+contact +" to "+contactGroup);
    }

    public void removeMember(String contact, String contactGroup) {
        System.out.println("Removed "+contact +" from "+contactGroup);
    }
}
