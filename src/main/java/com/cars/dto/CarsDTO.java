package com.cars.dto;

import com.cars.Car;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CarsDTO {
    private Car[] cars;

    public CarsDTO(@JsonProperty("cars") Car[] cars) {
        this.cars = cars.clone();
    }

    public Car[] getCars() {
        return cars;
    }
    public Car[] addCar(Car[] cars){
        this.cars = cars;
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }
}
