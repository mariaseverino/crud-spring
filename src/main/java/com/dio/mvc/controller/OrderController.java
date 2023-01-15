package com.dio.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.mvc.model.Order;
import com.dio.mvc.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/save")
    public ResponseEntity<Order> saveProduct(@RequestBody Order order) throws Exception{
        order = service.save(order);
        return ResponseEntity.ok().body(order);
        // return order;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> searchProduct(@PathVariable Long id){
        Order order = service.findById(id);

        return ResponseEntity.ok().body(order);
        // return order;
    }
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){

        List<Order> orders = service.findAll();
        return ResponseEntity.ok().body(orders);

    }
}
