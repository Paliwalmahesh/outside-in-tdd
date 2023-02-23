package com.cars;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String id;
    private String carMake;
    private int year;

    public Car(@JsonProperty("id") String id, @JsonProperty("car") String carMake, @JsonProperty("car_model_year") int year) {
        this.id = id;
        this.carMake = carMake;
        this.year = year;
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
}
