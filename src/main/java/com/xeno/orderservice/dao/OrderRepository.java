package com.xeno.orderservice.dao;

import com.xeno.orderservice.entity.OrderEntity;
import com.xeno.orderservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

    List<OrderEntity> findAllByUserEntity(UserEntity user);
}
