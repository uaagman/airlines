package edu.mum.jsfBeans;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ashok on 6/9/17.
 */
@Named
@RequestScoped
public class airlineController {
    @Inject
    AirlineService airlineService;

    Airline airline;

    airlineController(){
        airline = new Airline();
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public List<Airline> getAirlines(){
        return airlineService.findAll();
    }

    public String save(){
        if(!airline.getName().equals("")){
            airlineService.create(airline);
        }
        return null;
    }
    public String delete(Airline airline){
        airlineService.delete(airline);
        return null;
    }
    public String update(Airline airline){
        airlineService.update(airline);
        return null;
    }

}
