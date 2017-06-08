package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Named
@Path("hello")
public class HelloRest {

    @Inject
    private AirlineService airlineService;

    @GET
    public Response helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
        String  result = "Hello " + name + "!";
        return Response.status(200).entity(result).build();
    }

    @Path("airline")
    @GET
    public Response getAirlineTest() {
        String result = "Nil!";
        Airline airline = airlineService.findByName("oneworld");
        if (airline != null) {
            result = "This is an airline: " + airline.getName();
        }
        return Response.status(200).entity(airline).build();
    }

    @Path("saveAirline")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public Response saveAirline(final MultivaluedMap<String, String> formParams){
        airlineService.create(new Airline(formParams.getFirst("name")));

        return Response.status(200).entity(airlineService.findByName(formParams.getFirst("name"))).build();
    }

}
