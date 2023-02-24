package com.cars;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String id;
    private String carMake;
    private int year;
    private String model;
    private String colour;

    public Car(@JsonProperty("id") String id, @JsonProperty("car") String carMake, @JsonProperty("car_model_year") int year, @JsonProperty("car_model") String model, @JsonProperty("car_color") String colour) {
        this.id = id;
        this.carMake = carMake;
        this.year = year;
        this.model = model;
        this.colour = colour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(id);
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
