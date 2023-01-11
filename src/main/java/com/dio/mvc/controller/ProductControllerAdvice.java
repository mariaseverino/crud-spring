package com.dio.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dio.mvc.exception.ProductAlreadyExistsException;
import com.dio.mvc.exception.ProductNullException;
import com.dio.mvc.exception.ProductPriceException;

@ControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> captureErrorNull(){

        Map<String, Object> body = new HashMap<String, Object>();

        body.put("message", "Verifique os campos do produto");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> captureErrorPrice(){
        Map<String, Object> body = new HashMap<String, Object>();

        body.put("message", "Verifique o preço do produto");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<Object> captureError(){
        Map<String, Object> body = new HashMap<String, Object>();

        body.put("message", "Esse produto já esta cadastrado");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
