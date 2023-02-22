package com.company.app.services;

import com.company.app.model.Car;
import com.company.app.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public Car insert(Car todo) {
        return carRepository.save(todo);
    }

    @Override
    public void updateCar(Long id, Car todo) {
        Car carFromDb = carRepository.findById(id).get();
        System.out.println(carFromDb);
        carFromDb.setStatus(todo.getStatus());
        carFromDb.setDescription(todo.getDescription());
        carFromDb.setTitle(todo.getTitle());
        carRepository.save(carFromDb);
    }

    @Override
    public void deleteCar(Long todoId) {
        carRepository.deleteById(todoId);
    }
}
