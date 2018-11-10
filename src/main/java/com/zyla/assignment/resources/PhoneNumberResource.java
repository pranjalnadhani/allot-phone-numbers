package com.zyla.assignment.resources;

import com.zyla.assignment.api.PhoneNumber;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("allotnumber")
@Produces(MediaType.APPLICATION_JSON)
public class PhoneNumberResource {
    @GET
    public PhoneNumber generateNumber() {
        return new PhoneNumber("1111111111");
    }

    @POST
    public PhoneNumber allotCustomNumber() {
        return new PhoneNumber("9989989988");
    }
}
