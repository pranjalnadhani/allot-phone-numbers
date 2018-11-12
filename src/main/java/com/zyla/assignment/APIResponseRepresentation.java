package com.zyla.assignment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APIResponseRepresentation<T> {
    private String status;
    private T data;

    public APIResponseRepresentation(String status, T data) {
        this.status = status;
        this.data = data;
    }

    @JsonProperty
    public String getStatus() {
        return status;
    }

    @JsonProperty
    public T getData() {
        return data;
    }
}
