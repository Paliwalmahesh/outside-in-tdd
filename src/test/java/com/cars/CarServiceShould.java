package com.cars;

import com.cars.dto.CarsDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CarServiceShould {
    @Mock
    CarClient carClient;
    CarService carService;

    @Test
    @DisplayName("call CarClient")
    void call_car_client() {
        carService = new CarService(carClient);
        carService.getCarWrapper("1");
        Mockito.verify(carClient).fetch("1");
    }

    @Test
    @DisplayName("call CarClient for car list")
    void call_car_client_for_car_list() {
        carService = new CarService(carClient);
        carService.getCars();
        Mockito.verify(carClient).fetchAll();
    }

    @Test
    @DisplayName("call CarClient for car list by year")
    void call_car_client_for_car_list_by_year() {
        carService = new CarService(carClient);
        carService.getCars();
        Mockito.verify(carClient).fetchAll();
    }

    @Test
    @DisplayName("should return all cars by year 2008")
    void should_return_all_cars_by_year_2008() {
        carService = new CarService(carClient);
        Car[] cars = new Car[] {
                new Car("1", "Mitsubishi", 2002, "BMW", "Maroon"),
                new Car("2", "Nano", 2008, "Volkswagen", "Maroon"),
                new Car("3", "Hyundai", 2008, "Volkswagen", "Maroon"),
                new Car("4", "Creta", 2009, "BMW", "Maroon")
        };
        Mockito.when(carClient.fetchAll()).thenReturn(new CarsDTO(cars));
        Car[] returnedCars = carService.getCarsByYear(2008).getCars();
        Assertions.assertThat(returnedCars)
                .allSatisfy(car -> Assertions.assertThat(car.getYear()).isEqualTo(2008));
    }

    @Test
    @DisplayName("should return all cars by model Compass")
    void should_return_all_cars_by_model_compass() {
        carService = new CarService(carClient);
        Car[] cars = new Car[] {
                new Car("1", "Mitsubishi", 2002, "Compass", "Maroon"),
                new Car("2", "Nano", 2008, "Volkswagen", "Maroon"),
                new Car("3", "Hyundai", 2008, "Volkswagen", "Maroon"),
                new Car("4", "Creta", 2009, "Compass", "Maroon")
        };
        Mockito.when(carClient.fetchAll()).thenReturn(new CarsDTO(cars));
        Car[] returnedCars = carService.getCarsByModel("Compass").getCars();
        Assertions.assertThat(returnedCars)
                .allSatisfy(car -> Assertions.assertThat(car.getModel()).isEqualTo("Compass"));
    }
    @Test
    @DisplayName("return all cars of colour Maroon")
    void return_all_cars_of_colour_maroon() {

        carService = new CarService(carClient);
        Car[] cars = new Car[] {
                new Car("1", "Mitsubishi", 2002, "Compass","Maroon"),
                new Car("2", "Nano", 2008, "Volkswagen", "Orange"),
                new Car("3", "Hyundai", 2008, "Volkswagen", "Maroon"),
                new Car("4", "Creta", 2009, "Compass", "Black")
        };
        Mockito.when(carClient.fetchAll()).thenReturn(new CarsDTO(cars));
        Car[] returnedCars = carService.getCarsByColour("Maroon").getCars();
        Assertions.assertThat(returnedCars)
                .allSatisfy(car -> Assertions.assertThat(car.getColour()).isEqualTo("Maroon"));
        }
}
