package com.eduardocode.objectorienteddesign.designpatterns.structural.facade.booking;

public class Hotel {

    private String hotelName;
    private String city;
    private String country;

    public Hotel() {
        hotelName = city = country = null;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
