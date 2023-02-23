package com.cars;

import com.cars.dto.CarDTO;
import com.cars.dto.CarsDTO;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@MicronautTest
public class CarControllerTest {
    CarController carController;

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    @DisplayName("Should return Car")
    void should_return_car() {
        CarDTO carDTO = httpClient.toBlocking().retrieve("cars/1", CarDTO.class);
        Car car = carDTO.getCar();
        Assertions.assertThat(car.getId()).isEqualTo("1");
        Assertions.assertThat(car.getCarMake()).isEqualTo("Mitsubishi");
    }

    @Test
    @DisplayName("should return cars")
    void should_return_cars() {
        CarsDTO carsDTO = httpClient.toBlocking().retrieve("cars", CarsDTO.class);
        Car[] cars = carsDTO.getCars();

        Assertions.assertThat(cars[1].getId()).isEqualTo("2");
        Assertions.assertThat(cars[1].getCarMake()).isEqualTo("Volkswagen");
        Assertions.assertThat(cars.length).isEqualTo(1000);
    }

    @Test
    @DisplayName("return cars by year")
    void return_cars_by_year() {
        CarsDTO carsDTO = httpClient.toBlocking().retrieve("cars/year/2008", CarsDTO.class);
        Car[] cars = carsDTO.getCars();
        Assertions.assertThat(cars.length).isEqualTo(48);
    }

    @Test
    @DisplayName("return cars by model")
    void return_cars_by_model() {
        CarsDTO carsDTO = httpClient.toBlocking().retrieve("cars/model/Compass", CarsDTO.class);
        Car[] cars = carsDTO.getCars();
        Assertions.assertThat(cars.length).isEqualTo(2);
    }
}
