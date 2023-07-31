package com.airstack.ta.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Address {


    @JsonProperty("_eq")
    private String eq;

    public String getEq() {
        return eq;
    }

    public void setEq(String eq) {
        this.eq = eq;
    }

}
