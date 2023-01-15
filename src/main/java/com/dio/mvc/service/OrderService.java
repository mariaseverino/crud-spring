package com.dio.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.mvc.model.Order;
import com.dio.mvc.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order save(Order order) throws Exception{
        return repository.save(order);
    }

    public Order findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Order> findAll(){
        return repository.findAll();
    }

    public void deleteAll(){
        repository.deleteAll();
    }
}
