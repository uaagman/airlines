package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
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
    public Response getAirline(@PathParam("id") long id) {
        try {
            return Response.status(200).entity(airlineService.findById(id)).build();
        }catch (Exception ex){
            return Response.status(500).entity("").build();
        }
    }

    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response saveAirline(Airline airline){
        try {
            airlineService.create(airline);
            return Response.ok().entity(airlineService.findByName(airline.getName())).build();
        }catch (Exception exp){
            return Response.status(500).entity("").build();
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
    public Response deleteAirline(@PathParam("id") long id){
        try{
            Airline airline = airlineService.findById(id);
            airlineService.delete(airline);
            return Response.status(200).entity(airline).build();
        }catch (Exception ex){
            return Response.status(500).entity("").build();
        }
    }

    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Response updateAirline(Airline airline){
        try{
            return Response.status(200).entity(airlineService.update(airline)).build();
        }catch (Exception ex){
            return Response.status(500).entity("").build();
        }
    }
}
