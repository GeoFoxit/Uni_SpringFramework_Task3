package com.georgeborodin.web_app.controller;

import com.georgeborodin.web_app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cars")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

}
