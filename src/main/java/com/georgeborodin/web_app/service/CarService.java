package com.georgeborodin.web_app.service;

import com.georgeborodin.web_app.domain.Car;
import com.georgeborodin.web_app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car saveOrUpdate(Car car) {
        return carRepository.save(car);
    }

    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(Integer id) {
        return carRepository.getById(id);
    }

    public void delete(Integer id) {
        Car car = findById(id);
        carRepository.delete(car);
    }

}
