package com.xeno.orderservice.controller;

import com.xeno.orderservice.entity.ProductEntity;
import com.xeno.orderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addAProduct(@RequestBody ProductEntity productEntity){
        try{
            ProductEntity product = productService.addAProduct(productEntity);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }catch (Exception e){
            HashMap<String,String> response = new HashMap<>();
            response.put("message","An Error Occurred while adding product to the database");
            response.put("error",String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{productID}")
    public ResponseEntity<?> fetchAProduct(@PathVariable("productID") Long productID){
        try{
            ProductEntity product = productService.fetchAProduct(productID);
            if(product!=null)
                return new ResponseEntity<>(product, HttpStatus.FOUND);
            else
                return new ResponseEntity<>(new HashMap<>().put("message","No product was found which is associated with this ID"),HttpStatus.NOT_FOUND);
        }catch (Exception e){
            HashMap<String,String> response = new HashMap<>();
            response.put("message","An Error Occurred while fetching Product from the database");
            response.put("error",String.valueOf(e));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
