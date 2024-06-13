package com.oscar.atienza;

import java.util.Arrays;

public class Ship {
    private String name;
    private String model;
    private String cost_in_credits;
    private String crew;
    private String cargo_capacity;
    private String consumables;
    private String hyperdrive_rating;
    private String starship_class;
    private String[] pilots;
    private String[] films;


    public Ship(String name, String model, String cost_in_credits, String crew, String cargo_capacity, String consumables, String hyperdrive_rating, String starship_class, String[] pilots, String[] films) {
        this.name = name;
        this.model = model;
        this.cost_in_credits = cost_in_credits;
        this.crew = crew;
        this.cargo_capacity = cargo_capacity;
        this.consumables = consumables;
        this.hyperdrive_rating = hyperdrive_rating;
        this.starship_class = starship_class;
        this.pilots = pilots;
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getCargo_capacity() {
        return cargo_capacity;
    }

    public void setCargo_capacity(String cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdrive_rating() {
        return hyperdrive_rating;
    }

    public void setHyperdrive_rating(String hyperdrive_rating) {
        this.hyperdrive_rating = hyperdrive_rating;
    }

    public String getStarship_class() {
        return starship_class;
    }

    public void setStarship_class(String starship_class) {
        this.starship_class = starship_class;
    }

    public String[] getPilots() {
        return pilots;
    }

    public void setPilots(String[] pilots) {
        this.pilots = pilots;
    }

    public String[] getFilms() {
        return films;
    }

    public void setFilms(String[] films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", cost_in_credits='" + cost_in_credits + '\'' +
                ", crew='" + crew + '\'' +
                ", cargo_capacity='" + cargo_capacity + '\'' +
                ", consumables='" + consumables + '\'' +
                ", hyperdrive_rating='" + hyperdrive_rating + '\'' +
                ", starship_class='" + starship_class + '\'' +
                ", pilots=" + Arrays.toString(pilots) +
                ", films=" + Arrays.toString(films) +
                '}';
    }
}
