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

import com.dio.mvc.model.Product;
import com.dio.mvc.service.ProductService;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws Exception{
        product = service.save(product);
        return ResponseEntity.ok().body(product);
        // return product;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> searchProduct(@PathVariable Long id){
        Product product = service.findById(id);

        return ResponseEntity.ok().body(product);
        // return product;
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = service.findAll();

        return ResponseEntity.ok().body(products);

        // Product product = service.findById(id);

        // return ResponseEntity.ok().body(product);
    }
    // public void saveProduct(){
    //     // Product product = new Product();

    //     // product.setName("a");
    //     // product.setPrice(80.5);
    //     // product.setDescription("a");

    //     // service.save(product);
    //     service.deleteAll();
    // }
}
