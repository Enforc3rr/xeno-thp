package com.xeno.orderservice.service;

import com.xeno.orderservice.entity.OrderEntity;
import com.xeno.orderservice.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    UserEntity userSignup(UserEntity userEntity);
    UserEntity findUserById(Long userID);

    List<OrderEntity> findOrderDetails(Long userID);
}
