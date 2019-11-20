package com.georgeborodin.web_app.controller;

import com.georgeborodin.web_app.domain.Car;
import com.georgeborodin.web_app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/cars")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("")
    public ResponseEntity<?> createCar(@Valid @RequestBody Car car, BindingResult result) {
        if(result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Car newCar = carService.saveOrUpdate(car);
        return new ResponseEntity<Car>(newCar, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/{car_id}")
    public ResponseEntity<?> getCarById(@PathVariable Integer car_id) {
        Car car = carService.findById(car_id);
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @DeleteMapping("/{car_id}")
    public ResponseEntity<?> deleteCar(@PathVariable Integer car_id) {
        carService.delete(car_id);
        return new ResponseEntity<String>("Car deleted", HttpStatus.OK);
    }

}
