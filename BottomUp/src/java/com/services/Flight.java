package com.services;

public class Flight {
    private String depCity;
    private String destCity;
    private String date;
    private int price;

    public Flight(String depCity, String destCity, String date, int price){
        this.depCity = depCity;
        this.destCity = destCity;
        this.date = date;
        this.price = price;
    }

    public String getDepCity() {
        return this.depCity;
    }
    public void setDepCity(java.lang.String depCity) {
        this.depCity = depCity;
    }

    public String getDestCity() {
        return this.destCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
