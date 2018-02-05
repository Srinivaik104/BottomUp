package com.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(
serviceName = "FlightResBottomUp"
)
@Stateless()
public class FlightResBottomUp {
    public FlightResBottomUp() {
        FlightData.init();
    }

    @WebMethod(
            operationName = "login"
    )
    public String login(@WebParam(name = "username") String usn, @WebParam(name = "password") String pwd) throws UnauthorizedException {
        if (FlightData.authorize(usn, pwd)) {
            return "SecretTokenThatAllowsAccess";
        } else {
            throw new UnauthorizedException("Not authorized");
        }
    }

    @WebMethod(
            operationName = "getItineraries"
    )
    public List<Itinerary> getItineraries(@WebParam(name = "authToken") String authToken, @WebParam(name = "departureCity") String depCity, @WebParam(name = "destinationCity") String destCity, @WebParam(name = "date") String date) throws UnauthorizedException {
        if (!authToken.equals("SecretTokenThatAllowsAccess")) {
            throw new UnauthorizedException("Not authorized");
        } else {
            return FlightData.getItineraries(depCity, destCity, date);
        }
    }
}
