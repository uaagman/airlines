package edu.mum.jsfBeans;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
        try {
            if (!airline.getName().equals("")) {
                airlineService.create(airline);
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Airline Created with ID "+airline.getId()+" and name = "+airline.getName(),""));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Name shouldn't be empty",""));
            }
        }catch (Exception ex){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error Saving Data either due to duplicate key or database error",ex.getMessage()));
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
