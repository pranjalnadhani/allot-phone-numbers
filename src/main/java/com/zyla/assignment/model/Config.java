package com.zyla.assignment.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Config {
    @NotEmpty
    private String key;
    @NotEmpty
    private String val;

    public Config(final String key, final String val) {
        this.key = key;
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
