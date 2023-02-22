package com.company.app.controllers;

import com.company.app.model.Car;
import com.company.app.services.CarService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping({"/{carId}"})
    public ResponseEntity<Car> getCar(@PathVariable Long carId) {
        return new ResponseEntity<>(carService.getCarById(carId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        Car car1 = carService.insert(car);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("car", "/api/v1/car/" + car1.getId().toString());
        return new ResponseEntity<>(car1, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{carId}"})
    public ResponseEntity<Car> updateCar(@PathVariable("carId") Long carId, @RequestBody Car car) {
        carService.updateCar(carId, car);
        return new ResponseEntity<>(carService.getCarById(carId), HttpStatus.OK);
    }

    @DeleteMapping({"/{carId}"})
    public ResponseEntity<Car> deleteCar(@PathVariable("carId") Long carId) {
        carService.deleteCar(carId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
