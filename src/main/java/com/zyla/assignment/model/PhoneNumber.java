package com.zyla.assignment.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneNumber {
    @JsonProperty("phone")
    private long phone;

    @JsonCreator
    public PhoneNumber(@JsonProperty("phone") long phone) {
        this.phone = phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
