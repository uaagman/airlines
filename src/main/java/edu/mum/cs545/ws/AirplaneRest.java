package edu.mum.cs545.ws;

import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;

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
@Path("airplane")
public class AirplaneRest {
    @Inject
    AirplaneService airplaneService;

    @Path("")
    @GET
    public List<Airplane> getAllAirplanes() {
        try {
            return airplaneService.findAll();
        }catch (Exception ex){
            return null;
        }
    }

    @Path("{id}")
    @GET
    public Airplane getAirplane(@PathParam("id") long id) {
        try {
            return airplaneService.findById(id);
        }catch (Exception ex){
            return null;
        }
    }

    @Path("serial")
    @GET
    public Airplane getAirplanes(@QueryParam("serialNo") String serialNo) {
        try {
            return airplaneService.findBySrlnr(serialNo);
        }catch (Exception ex){
            return null;
        }
    }

    @Path("model")
    @GET
    public List<Airplane> getAirplaneByModel(@QueryParam("model") String modelNo) {
        try {
            return airplaneService.findByModel(modelNo);
        }catch (Exception ex){
            return null;
        }
    }

    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Airplane saveAirplanes(Airplane airplane){
        try {
            airplaneService.create(airplane);
            return airplaneService.find(airplane);
        }catch (Exception exp){
            return null;
        }
    }

    @Path("delete/{id}")
    @DELETE
    public Airplane deleteAirplane(@PathParam("id") long id){
        try{
            Airplane airplane = airplaneService.findById(id);
            airplaneService.delete(airplane);
            return airplane;
        }catch (Exception ex){
            return null;
        }
    }

    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Airplane updateAirplane(Airplane airplane){
        try{
            return airplaneService.update(airplane);
        }catch (Exception ex){
            return null;
        }
    }
}
