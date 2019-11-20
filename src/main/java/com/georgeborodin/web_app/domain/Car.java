package com.georgeborodin.web_app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Naming cannot be blank")
    private String naming;
    @NotNull(message = "Price cannot be blank")
    private Float price;

    public Car() {}

    public Car(String naming, Float price) {
        this.naming = naming;
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }
    public String getNaming() {
        return naming;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public Float getPrice() {
        return price;
    }
}
