package com.xeno.orderservice.service;

import com.xeno.orderservice.entity.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductService{
    ProductEntity addAProduct(ProductEntity productEntity);
    ProductEntity fetchAProduct(Long productID);
}
