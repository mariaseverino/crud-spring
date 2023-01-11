package com.dio.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.mvc.exception.ProductAlreadyExistsException;
import com.dio.mvc.exception.ProductNullException;
import com.dio.mvc.exception.ProductPriceException;
import com.dio.mvc.model.Product;
import com.dio.mvc.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product save(Product product) throws Exception{
        if (product.getName() == null || product.getPrice() == null){
            throw new ProductNullException();
        }

        if (product.getPrice() < 0){
            throw new ProductPriceException();
        }
        Product productAlreadyExists = repository.findByName(product.getName());

        if (productAlreadyExists == null){
            return repository.save(product);

        }

        throw new ProductAlreadyExistsException();
    }

    public Product findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public void deleteAll(){
        repository.deleteAll();
    }
}
