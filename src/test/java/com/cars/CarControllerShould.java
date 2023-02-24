package com.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CarControllerShould {
    CarController carController;

    @Mock
    CarService carService;

    @Test
    @DisplayName("call CarService ")
    void call_car_service() {
        carController = new CarController(carService);
        carController.getCarWrapper("1");
        Mockito.verify(carService).getCarWrapper("1");
    }

    @Test
    @DisplayName("call CarService for carList")
    void call_car_service_for_car_list() {
        carController = new CarController(carService);
        carController.getCars();
        Mockito.verify(carService).getCars();
    }

    @Test
    @DisplayName("call CarService for carList of the year")
    void call_car_service_for_car_list_of_the_year() {
        carController = new CarController(carService);
        carController.getCarsByYear(2008);
        Mockito.verify(carService).getCarsByYear(2008);
    }

    @Test
    @DisplayName("call CarService for carList of the model")
    void call_car_service_for_car_list_of_the_model() {
        carController = new CarController(carService);
        carController.getCarsByModel("Compass");
        Mockito.verify(carService).getCarsByModel("Compass");
    }
    @Test
    @DisplayName("call CarService for CarList of the colour")
    void call_car_service_for_car_list_of_the_colour() {
        carController = new CarController(carService);
        carController.getCarsByColour("Maroon");
        Mockito.verify(carService).getCarsByColour("Maroon");
        }
}
