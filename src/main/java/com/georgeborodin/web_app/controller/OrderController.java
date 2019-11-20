package com.georgeborodin.web_app.controller;

import com.georgeborodin.web_app.domain.Order;
import com.georgeborodin.web_app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public ResponseEntity<?> createOrder(@Valid @RequestBody Order order, BindingResult result) {
        if(result.hasErrors()) {
            Map<String,String> errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Order newOrder = orderService.saveOrUpdate(order);
        return new ResponseEntity<Order>(newOrder, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Order> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer order_id) {
        Order order = orderService.findById(order_id);
        return new ResponseEntity<Order>(order,HttpStatus.OK);
    }

    @DeleteMapping("/{order_id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer order_id) {
        orderService.delete(order_id);
        return new ResponseEntity<String>("Order deleted", HttpStatus.OK);
    }

}
