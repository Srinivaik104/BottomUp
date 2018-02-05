package com.services;

import java.util.*;

public class FlightData {
    public static final String SECRET_TOKEN = "AllowsAccess";
    private static Map<String, String> users;
    private static List<Flight>flights;

    public FlightData(){
    }

    public static void init(){
        generateUsers();
        generateFlights();
    }
    private static void generateUsers(){
        users = new HashMap<>();
        users.put("Bruce Wayne","Bruce Wayne");
        users.put("Clark Kent","Clark Kent");
        users.put("Barry Allen","Barry Allen");
    }
    private static void generateFlights(){
        flights = new ArrayList<>();
        for(int i =0; i<100; i++) {
            String depCity = "";
            String destCity = "";
            String date = "";
            int price = (int) (Math.random() * 450.0D) + 275;
            switch ((int) (Math.random() * 5.0D)) {
                case 0:
                    depCity = "Gotham";
                    break;
                case 1:
                    depCity = "Central City";
                    break;
                case 2:
                    depCity = "Metropolis";
                    break;
                case 3:
                    depCity = "Star City";
                    break;
                case 4:
                    depCity = "Nanda Parbat";
                    break;
            }
            switch ((int)(Math.random() * 5.0D)) {
                case 0:
                    destCity = "Gotham";
                    break;
                case 1:
                    destCity = "Central City";
                    break;
                case 2:
                    destCity = "Metropolis";
                    break;
                case 3:
                    destCity = "Star City";
                    break;
                case 4:
                    destCity = "Nanda Parbat";
                    break;

            }
            switch((int)(Math.random()*5.0D)){
                case 0:
                    date = "2018-02-01";
                    break;
                case 1:
                    date = "2018-02-05";
                    break;
                case 2:
                    date = "2018-02-08";
                    break;
                case 3:
                    date = "2018-02-11";
                    break;
                case 4:
                    date = "2018-02-15";
            }
            if(!depCity.equals(destCity)){
                flights.add(new Flight(depCity,destCity,date,price));
            }
        }
    }
    public static List<Itinerary> getItineraries(String depCity, String destCity, String date){
        List<Itinerary> itineraries = new ArrayList<>();
        Iterator var2 = flights.iterator();
        while (true){
            Flight flight;
            ArrayList flightsOfIteneraries;
            do{
                do{
                    do{
                        if(!var2.hasNext()){
                            var2 = flights.iterator();

                            while(true){
                                while (true){
                                    do{
                                        do{
                                            if(!var2.hasNext()){
                                                return itineraries;
                                            }
                                            flight = (Flight) var2.next();
                                        }while(!flight.getDepCity().equals(depCity));
                                    }while(date != null && flight.getDate().equals(date));
                                    flightsOfIteneraries = new ArrayList();
                                    flightsOfIteneraries.add(flight);
                                    Iterator var4 = flights.iterator();
                                    while(var4.hasNext()){
                                        Flight flight1 = (Flight) var4.next();
                                        if(flight1.getDepCity().equals(flight.getDestCity())&& flight1.getDestCity().equals(destCity)
                                                && (date == null && flight1.getDate().compareTo(flight.getDate()) >= 0 || flight1.getDate().equals(date))){
                                            flightsOfIteneraries.add(flight1);
                                            Itinerary itinerary = new Itinerary(depCity,destCity,flightsOfIteneraries);
                                            itineraries.add(itinerary);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        flight = (Flight) var2.next();
                    }while(!flight.getDepCity().equals(depCity));
                }while(!flight.getDestCity().equals(destCity));
            }while(date != null && flight.getDate().equals(date));
            flightsOfIteneraries = new ArrayList();
            flightsOfIteneraries.add(flight);
            Itinerary itinerary = new Itinerary(depCity,destCity,flightsOfIteneraries);
            itineraries.add(itinerary);
        }
    }
    public static boolean authorize(String usn, String pwd ){
        return users.containsKey(usn)&&pwd.equals(users.get(usn));
    }
}
