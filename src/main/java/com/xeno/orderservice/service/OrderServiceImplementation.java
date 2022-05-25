package com.xeno.orderservice.service;

import com.xeno.orderservice.dao.OrderRepository;
import com.xeno.orderservice.dao.ProductRepository;
import com.xeno.orderservice.dao.UserRepository;
import com.xeno.orderservice.entity.OrderEntity;
import com.xeno.orderservice.entity.ProductEntity;
import com.xeno.orderservice.entity.UserEntity;
import com.xeno.orderservice.utils.OrderClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class OrderServiceImplementation implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public OrderEntity addAnOrder(OrderClass order) {
        UserEntity user = userRepository.findById(order.getOrderedBy()).get();
        HashSet<ProductEntity> productEntities = new HashSet<>();
        int totalPrice = 0;
        for(Long productID : order.getProducts()){
            ProductEntity product = productRepository.findById(productID).get();
            totalPrice +=product.getProductPrice();
            productEntities.add(product);
        }
        return orderRepository.save(new OrderEntity(totalPrice,user,productEntities));
    }

    @Override
    public OrderEntity fetchAnOrder(Long orderID) {
        return orderRepository.findById(orderID).get();
    }
}
