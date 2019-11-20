package com.georgeborodin.web_app.service;

import com.georgeborodin.web_app.domain.Order;
import com.georgeborodin.web_app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrUpdate(Order order) {
        return orderRepository.save(order);
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Integer id) {
        return orderRepository.getById(id);
    }

    public void delete(Integer id) {
        Order client = findById(id);
        orderRepository.delete(client);
    }

}
