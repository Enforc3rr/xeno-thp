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
    @Override
    public UserEntity deleteUser(Long userID) {
        UserEntity deletedUser = findUserById(userID);
        orderRepository.deleteById(userID);
        return deletedUser;
    }

    @Override
    public UserEntity updateUserDetails(UserEntity userEntity) {
        UserEntity user = findUserById(userEntity.getUserID());

        if(user.getName()!=null || !user.getName().equals(userEntity.getName()))
            user.setName(userEntity.getName());
        else if(user.getEmail()!=null || !user.getEmail().equals(userEntity.getEmail()))
            user.setName(userEntity.getName());
        else if(user.getAddress()!=null || !user.getAddress().equals(userEntity.getAddress()))
            user.setName(userEntity.getName());

        return userRepository.save(user);
    }
}
