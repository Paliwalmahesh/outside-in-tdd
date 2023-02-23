package com.cars.dto;

import com.cars.Car;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CarsDTO {
    private Car[] cars;

    public CarsDTO(@JsonProperty("cars") Car[] cars) {
        this.cars = cars;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }
}
