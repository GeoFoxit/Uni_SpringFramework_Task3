package com.georgeborodin.web_app.repository;

import com.georgeborodin.web_app.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car,Integer> {

}
