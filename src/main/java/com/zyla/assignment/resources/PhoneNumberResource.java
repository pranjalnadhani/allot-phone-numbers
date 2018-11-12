package com.zyla.assignment.resources;

import com.zyla.assignment.APIResponseRepresentation;
import com.zyla.assignment.model.PhoneNumber;
import com.zyla.assignment.service.PhoneNumberService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/allotnumber")
@Produces(MediaType.APPLICATION_JSON)
public class PhoneNumberResource {
    private static final String SUCCESS = "success";
    private final PhoneNumberService phoneNumberService;

    public PhoneNumberResource(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    @POST
    public APIResponseRepresentation<PhoneNumber> allotCustomNumber(final PhoneNumber customNumber) {
        return new APIResponseRepresentation<>(SUCCESS, phoneNumberService.generateNumber(customNumber));
    }
}
