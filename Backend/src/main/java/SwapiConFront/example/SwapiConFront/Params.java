package SwapiConFront.example.SwapiConFront;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class Params
{
    @JsonProperty
    private String parameter1;
    @JsonProperty
    private String parameter2;

    public Params() {
    }

    public Params(String parameter1, String parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
