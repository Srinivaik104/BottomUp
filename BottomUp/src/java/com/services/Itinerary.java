package com.services;

import java.util.Iterator;
import java.util.List;

public class Itinerary {
    private String depCity;
    private String destCity;
    private List<Flight> flights;
    public Itinerary(String depCity, String destCity, List<Flight> flights){
        this.depCity = depCity;
        this.destCity = destCity;
        this.flights = flights;
    }

    public String getDepCity() {
        return this.depCity;
    }

    public void setDepCity(String depCity) {
        this.depCity = depCity;
    }

    public String getDestCity() {
        return this.destCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public List<Flight> getFlights() {
        return this.flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
    public int getPrice() {
        int price = 0;
        Flight flight;
        if (this.flights != null) {
            for (Iterator vari = this.flights.iterator(); vari.hasNext(); price += flight.getPrice()) {
                flight = (Flight) vari.next();
            }

        }
        return price;
    }
}
