package edu.mum.cs545.ws;

import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by ashok on 6/9/17.
 */

@Named
@Path("airport")
public class AirportRest {
    @Inject
    AirportService airportService;

    @Path("")
    @GET
    public List<Airport> getAllAirports() {
        try {
            return airportService.findAll();
        }catch (Exception ex){
            return null;
        }
    }

    @Path("{id}")
    @GET
    public Airport getAirport(@PathParam("id") long id) {
        try {
            return airportService.findById(id);
        }catch (Exception ex){
            return null;
        }
    }

    @Path("code")
    @GET
    public Airport getAirportByCode(@QueryParam("code") String code) {
        try {
            return airportService.findByCode(code);
        }catch (Exception ex){
            return null;
        }
    }

    @Path("name")
    @GET
    public List<Airport> getAirportByName(@QueryParam("name") String name) {
        try {
            return airportService.findByName(name);
        }catch (Exception ex){
            return null;
        }
    }

    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Airport saveAirport(Airport airport){
        try {
            airportService.create(airport);
            return airportService.find(airport);
        }catch (Exception exp){
            return null;
        }
    }

    @Path("delete/{id}")
    @DELETE
    public Airport deleteAirport(@PathParam("id") long id){
        try{
            Airport airport = airportService.findById(id);
            airportService.delete(airport);
            return airport;
        }catch (Exception ex){
            return null;
        }
    }

    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Airport updateAirport(Airport airport){
        try{
            return airportService.update(airport);
        }catch (Exception ex){
            return null;
        }
    }
}
