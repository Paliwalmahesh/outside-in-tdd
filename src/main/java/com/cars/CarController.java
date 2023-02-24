package com.cars;

import com.cars.dto.CarDTO;
import com.cars.dto.CarsDTO;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Get("/{id}")
    public CarDTO getCarWrapper(String id) {
        return carService.getCarWrapper(id);
    }

    @Get()
    public CarsDTO getCars() {
        return carService.getCars();
    }

    @Get("year/{year}")
    public CarsDTO getCarsByYear(int year) {
        return carService.getCarsByYear(year);
    }

    @Get("model/{model}")
    public CarsDTO getCarsByModel(String model) {
        CarsDTO carsDTO = carService.getCarsByModel(model);
        return carsDTO;
    }
    @Get("colour/{colour}")
    public CarsDTO getCarsByColour(String colour) {
            CarsDTO carsDto = carService.getCarsByColour(colour);
            return  carsDto;
    }
}
