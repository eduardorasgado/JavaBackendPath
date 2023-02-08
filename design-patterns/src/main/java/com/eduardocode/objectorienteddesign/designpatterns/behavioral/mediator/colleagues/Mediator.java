package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.colleagues;

public interface Mediator {
    void send(String message, Colleague colleague);

    void setColleague(Colleague colleagueA);
}
