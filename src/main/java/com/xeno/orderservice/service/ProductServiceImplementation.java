package com.xeno.orderservice.service;

import com.xeno.orderservice.dao.ProductRepository;
import com.xeno.orderservice.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductEntity addAProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity fetchAProduct(Long productID) {
        return productRepository.findById(productID).orElseThrow(()->new NullPointerException("NOT_FOUND"));
    }
}
