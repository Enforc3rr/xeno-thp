package com.xeno.orderservice.service;

import com.xeno.orderservice.dao.OrderRepository;
import com.xeno.orderservice.dao.UserRepository;
import com.xeno.orderservice.entity.OrderEntity;
import com.xeno.orderservice.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public UserEntity userSignup(UserEntity userEntity) {
        return  userRepository.save(userEntity);
    }

    @Override
    public UserEntity findUserById(Long userID) {
        return userRepository.findById(userID).orElseThrow(()->new NullPointerException("NOT_FOUND"));
    }

    @Override
    public List<OrderEntity> findOrderDetails(Long userID) {
        return orderRepository.findAllByUserEntity(userRepository.findById(userID).get());
    }

}
