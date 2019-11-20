package com.georgeborodin.web_app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name = "invoice")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Car id cannot be blank")
    private Integer carId;
    @NotBlank(message = "Client id cannot be blank")
    private Integer clientId;

    public Order() {}

    public Order(Integer carId, Integer clientId) {
        this.carId = carId;
        this.clientId = clientId;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
    public Integer getCarId() {
        return carId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
    public Integer getClientId() {
        return clientId;
    }
}
