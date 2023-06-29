package org.vaadin.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class Param
{
    @JsonProperty
    private String parameter1;
    @JsonProperty
    private int parameter2;

    public Param() {
    }

    public Param(String parameter1, int parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public int getParameter2() {
        return parameter2;
    }

    public void setParameter2(int parameter2) {
        this.parameter2 = parameter2;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
