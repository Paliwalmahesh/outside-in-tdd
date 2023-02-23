package com.cars.dto;

import com.cars.Car;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDTO {
    private Car car;
    public CarDTO(@JsonProperty("Car") Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
