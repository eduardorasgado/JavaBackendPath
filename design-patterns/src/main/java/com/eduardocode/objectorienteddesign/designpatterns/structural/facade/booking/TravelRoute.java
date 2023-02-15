package com.eduardocode.objectorienteddesign.designpatterns.structural.facade.booking;

public class TravelRoute {
    public Hotel getHotel() {
        return new Hotel();
    }

    public Flight getFlight() {
        return new Flight();
    }
}
