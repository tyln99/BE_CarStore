package com.company.app.services;

import com.company.app.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();

    Car getCarById(Long id);

    Car insert(Car todo);

    void updateCar(Long id, Car todo);

    void deleteCar(Long todoId);
}
