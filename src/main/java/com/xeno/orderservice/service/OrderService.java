package com.xeno.orderservice.service;

import com.xeno.orderservice.entity.OrderEntity;
import com.xeno.orderservice.utils.OrderClass;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderEntity addAnOrder(OrderClass orderEntity);
    OrderEntity fetchAnOrder(Long orderID);
}
