package edu.mum.jsfBeans;

import cs545.airline.model.Airline;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashok on 6/9/17.
 */

@Named
@RequestScoped
public class JsfController{

    @Inject
    FlightService flightService;
    @Inject
    AirlineService airlineService;
    @Inject
    AirportService airportService;

    private static Map<String, String> filterValues;
    private static List<Flight> flights;

    static {
        filterValues = new LinkedHashMap<>();
        filterValues.put("--Select One--", "");
        filterValues.put("Airline", "airline");
        filterValues.put("Destination", "destination");
        filterValues.put("Departure date", "departure");
        filterValues.put("Arrival date", "arrival");
    }

    public Map<String, String> getFilterValues() {
        return filterValues;
    }

    public String updateFlights(String filterBy, String filterText) {
        if ("airline".equals(filterBy)) {
            Airline airline = airlineService.findByName(filterText);
            flights = flightService.findByAirline(airline);
        } else if ("destination".equals(filterBy)) {
            Airport airport = airportService.findByCode(filterText);
            flights = flightService.findByDestination(airport);
        } else if ("departure".equals(filterBy)) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
            try {
                flights = flightService.findByDeparture(df.parse(filterText));
            } catch (ParseException e) {
                e.printStackTrace();
                flights = null;
            }
        } else if ("arrival".equals(filterBy)) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
            try {
                flights = flightService.findByArrival(df.parse(filterText));
            } catch (ParseException e) {
                e.printStackTrace();
                flights = null;
            }
        } else {
            flights = flightService.findAll();
        }
        return null;
    }

    public List<Flight> getFlights() {
        if(flights != null){
            return flights;
        } else {
            return flightService.findAll();
        }
    }
}
