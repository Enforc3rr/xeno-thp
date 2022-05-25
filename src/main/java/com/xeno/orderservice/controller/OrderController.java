package com.xeno.orderservice.controller;

import com.xeno.orderservice.entity.OrderEntity;
import com.xeno.orderservice.service.OrderService;
import com.xeno.orderservice.utils.OrderClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping()
    public ResponseEntity<?> addAnOrder(@RequestBody OrderClass orderEntity){
        try{
            return new ResponseEntity<>(orderService.addAnOrder(orderEntity),HttpStatus.CREATED);
        }catch (Exception e){
            HashMap<String,String> response = new HashMap<>();
            response.put("message","An Error Occurred while adding an Order to the database");
            response.put("error",String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{orderID}")
    public ResponseEntity<?> getOrderDetails(@PathVariable("orderID") Long orderID ){
        try {
            return new ResponseEntity<>(orderService.fetchAnOrder(orderID),HttpStatus.FOUND);
        }catch (Exception e){
            HashMap<String,String> response = new HashMap<>();
            response.put("message","An Error Occurred while Fetching an Order from the database");
            response.put("error",String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
