package org.vaadin.example;

import com.google.gson.Gson;

public class Planet
{
    private String name;
    private String climate;
    private String gravity;
    private String population;

    public Planet() {
    }

    public Planet(String name, String climate, String gravity, String population) {
        this.name = name;
        this.climate = climate;
        this.gravity = gravity;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String MostrarJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
