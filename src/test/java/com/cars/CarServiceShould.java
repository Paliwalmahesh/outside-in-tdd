package com.cars;

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
}
