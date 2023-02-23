package com.cars;

import com.cars.dto.CarDTO;
import com.cars.dto.CarsDTO;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class CarService {
    private CarClient carClient;

    public CarService(CarClient carClient) {
        this.carClient = carClient;
    }

    public CarDTO getCarWrapper(String id) {
        return carClient.fetch(id);
    }

    public CarsDTO getCars() {
        return carClient.fetchAll();
    }

    public Car[] getCarsByYear(int year) {
        CarsDTO carsDTO = carClient.fetchAll();
        List<Car> cars = List.of(carsDTO.getCars());
        return cars.stream()
                .filter(car -> car.getYear() == year).toArray(Car[]::new);
    }
}
