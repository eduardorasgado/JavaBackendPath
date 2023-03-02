package com.eduardocode.objectorienteddesign.designpatterns.behavioral.command.emailservice;

public class EmailServiceDemo {

    public static void main(String[] args) throws InterruptedException {
        EmailWebService webService = new EmailWebService();

        Command c1 = new AddMemberCommand(webService, "example1@gmail.com", "exampleGroup");
        Command c2 = new AddMemberCommand(webService, "example2@gmail.com", "exampleGroup");
        Command c3 = new AddMemberCommand(webService, "ads1000@addshere.com", "spam");

        MailTaskRunner taskRunner = MailTaskRunner.getInstance();

        Thread.sleep(2000);
        taskRunner.addCommand(c1);
        Thread.sleep(2000);
        taskRunner.addCommand(c2);
        Thread.sleep(2000);
        taskRunner.addCommand(c3);
        Thread.sleep(2000);
        taskRunner.shutdown();
    }
}
