package com.eduardocode.objectorienteddesign.designpatterns.structural.facade.booking;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TravelFacade {

    private final HotelBooker hotelBooker;
    private final FlightBooker flightBooker;

    public TravelFacade() {
        hotelBooker = new HotelBooker();
        flightBooker = new FlightBooker();
    }

    public List<TravelRoute> getTravelRoutes(Date from, Date to) {
        List<Flight> flights = flightBooker.getFlightsFor(from, to);
        List<Hotel> hotels = hotelBooker.getHotelsFor(from, to);

        return Collections.emptyList();
    }

    public void bookTravelRoute(TravelRoute travelRoute) {
        hotelBooker.bookHotel(travelRoute.getHotel());
        flightBooker.bookFlight(travelRoute.getFlight());
    }
}
