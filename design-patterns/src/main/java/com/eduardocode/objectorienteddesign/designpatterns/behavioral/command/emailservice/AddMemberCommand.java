package com.eduardocode.objectorienteddesign.designpatterns.behavioral.command.emailservice;

import static java.util.Objects.isNull;

public class AddMemberCommand implements Command{
    private final EmailWebService service;

    private final String contact;
    private final String contactGroup;

    public AddMemberCommand(EmailWebService service, String contact, String contactGroup) {
        if(isNull(service) || isNull(contact) || isNull(contactGroup)) {
            throw  new IllegalArgumentException();
        }

        this.service = service;
        this.contact = contact;
        this.contactGroup = contactGroup;
    }

    @Override
    public void execute() {
        // here we can use any helper object to extract objects from a given context like in spring to get beans
        // in order to void inserting the service as parameter of constructor and pass it as parameter of addMember method
        addMember(contact, contactGroup, service);
    }

    private void addMember(String contact, String contactGroup, EmailWebService service) {
        service.addMember(contact, contactGroup);
    }
}
