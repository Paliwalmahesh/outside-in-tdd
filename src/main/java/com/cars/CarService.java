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

    public CarsDTO getCarsByYear(int year) {
        CarsDTO carsDTO = carClient.fetchAll();
        List<Car> cars = List.of(carsDTO.getCars());
        final Car[] filteredCars = cars.stream()
                .filter(car -> car.getYear() == year).toArray(Car[]::new);
        return new CarsDTO(filteredCars.clone());
    }

    public CarsDTO getCarsByModel(String model) {
        CarsDTO carsDTO = carClient.fetchAll();
        List<Car> cars = List.of(carsDTO.getCars());
        final Car[] filteredCars = cars.stream().
                filter(car -> car.getModel().equals(model))
        .toArray(Car[]::new);
        carsDTO.addCar(filteredCars);
        return carsDTO;
    }
}
