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
    public Response getAirplane(@PathParam("id") long id) {
        try {
            return Response.status(200).entity(airplaneService.findById(id)).build();
        }catch (Exception ex){
            return Response.status(500).entity(ex.getMessage()).build();
        }
    }

    @Path("serial")
    @GET
    public Response getAirplanes(@QueryParam("serialNo") String serialNo) {
        try {
            return Response.status(200).entity(airplaneService.findBySrlnr(serialNo)).build();
        }catch (Exception ex){
            return Response.status(500).entity(ex.getMessage()).build();
        }
    }

    @Path("model")
    @GET
    public Response getAirplaneByModel(@QueryParam("model") String modelNo) {
        try {
            return Response.status(200).entity(airplaneService.findByModel(modelNo)).build();
        }catch (Exception ex){
            return Response.status(500).entity(ex.getMessage()).build();
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
    public Response deleteAirplane(@PathParam("id") long id){
        try{
            Airplane airplane = airplaneService.findById(id);
            airplaneService.delete(airplane);
            return Response.status(200).entity(airplane).build();
        }catch (Exception ex){
            return Response.status(500).entity(ex.getMessage()).build();
        }
    }

    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Response updateAirplane(Airplane airplane){
        try{
            return Response.status(200).entity(airplaneService.update(airplane)).build();
        }catch (Exception ex){
            return Response.status(500).entity(ex.getMessage()).build();
        }
    }
}
