package com.cars;

import com.cars.dto.CarDTO;
import com.cars.dto.CarsDTO;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("https://myfakeapi.com/api/cars")
public interface CarClient {
    @Get("/{id}")
    CarDTO fetch(String id);

    @Get()
    CarsDTO fetchAll();
}
