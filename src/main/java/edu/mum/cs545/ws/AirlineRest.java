package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ashok on 6/8/17.
 */

@Named
@Path("airline")
public class AirlineRest {
    @Inject
    private AirlineService airlineService;

    @Path("")
    @GET
    public List<Airline> getAllAirlines() {
        try {
            return airlineService.findAll();
        }catch (Exception ex){
            return null;
        }
    }

    @Path("{id}")
    @GET
    public Airline getAirline(@PathParam("id") long id) {
        try {
            return airlineService.findById(id);
        }catch (Exception ex){
            return null;
        }
    }

    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Airline saveAirline(Airline airline){
        try {
            airlineService.create(airline);
            return airlineService.findByName(airline.getName());
        }catch (Exception exp){
            return null;
        }
    }
    /*public Response saveAirline(final MultivaluedMap<String, String> formParams){
        try {
            String name = formParams.getFirst("name");
            airlineService.create(new Airline(name));
            return Response.status(200).entity(airlineService.findByName(name)).build();
        }catch (Exception exp){
            return Response.status(500).entity(exp.getMessage()).build();
        }

    }*/

    @Path("delete/{id}")
    @DELETE
    public Airline deleteAirline(@PathParam("id") long id){
        try{
            Airline airline = airlineService.findById(id);
            airlineService.delete(airline);
            return airline;
        }catch (Exception ex){
            return null;
        }
    }

    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Airline updateAirline(Airline airline){
        try{
            return airlineService.update(airline);
        }catch (Exception ex){
            return null;
        }
    }
}
