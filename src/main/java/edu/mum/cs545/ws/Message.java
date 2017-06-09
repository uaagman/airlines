package edu.mum.cs545.ws;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * Created by ashok on 6/9/17.
 */
public class Message {
    private Message(){}
    public static JsonObject error(String msg){
        return Json.createObjectBuilder().add("error",msg).build();
    }
    public static JsonObject success(String msg){
        return Json.createObjectBuilder().add("success",msg).build();
    }
}
