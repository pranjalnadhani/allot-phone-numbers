package com.zyla.assignment.mapper;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.dropwizard.jersey.errors.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.codahale.metrics.MetricRegistry.name;

public class JsonProcessingExceptionMapper implements ExceptionMapper<JsonProcessingException> {
    private final Meter exceptions;

    public JsonProcessingExceptionMapper(MetricRegistry metrics) {
        this.exceptions = metrics.meter(name(getClass(), "exceptions"));
    }

    @Override
    public Response toResponse(JsonProcessingException exception) {
        exceptions.mark();
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new ErrorMessage(Response.Status.BAD_REQUEST.getStatusCode(),
                        exception.toString()))
                .build();
    }
}
