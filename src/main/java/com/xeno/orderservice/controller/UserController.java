package com.xeno.orderservice.controller;

import com.xeno.orderservice.entity.OrderEntity;
import com.xeno.orderservice.entity.UserEntity;
import com.xeno.orderservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/signup" , consumes = "application/json")
    public ResponseEntity<?> userSignup(@RequestBody UserEntity userEntity){
        try{
            UserEntity user = userService.userSignup(userEntity);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch (Exception e){
            HashMap<String,String> response = new HashMap<>();
            response.put("message","An Error Occurred while adding user to the database");
            response.put("error",String.valueOf(e));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{userID}")
    public ResponseEntity<?> viewUser(@PathVariable("userID") Long userID){
        try{
            UserEntity user = userService.findUserById(userID);
            if(user!=null)
                return new ResponseEntity<>(user,HttpStatus.FOUND);
            else
                return new ResponseEntity<>(new HashMap<>().put("message","User Not Found"),HttpStatus.NOT_FOUND);

        }catch (Exception e){
            HashMap<String,String> response = new HashMap<>();
            response.put("message","An Error Occurred while fetching user from the database");
            response.put("error",String.valueOf(e));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateUserDetails")
    public ResponseEntity<?> updateDetails(@RequestBody UserEntity userEntity){
        try {
            return new ResponseEntity<>(userService.updateUserDetails(userEntity),HttpStatus.ACCEPTED);
        }catch (Exception e){
            HashMap<String,String> response = new HashMap<>();
            response.put("message","An Error Occurred while updating user into the database");
            response.put("error",String.valueOf(e));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteUser/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable("userID") Long userID){
        try {
            return new ResponseEntity<>(userService.deleteUser(userID),HttpStatus.OK);
        }catch (Exception e){
            HashMap<String,String> response = new HashMap<>();
            response.put("message","An Error Occurred while deleting user from the database");
            response.put("error",String.valueOf(e));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/orderDetails/{userID}")
    public ResponseEntity<?> orderDetails(@PathVariable("userID") Long userID){
        try{
            List<OrderEntity> orders = userService.findOrderDetails(userID);
            if(!orders.isEmpty())
                return new ResponseEntity<>(orders,HttpStatus.FOUND);
            else
                return new ResponseEntity<>(new HashMap<>().put("message","User Not Found"),HttpStatus.NOT_FOUND);

        }catch (Exception e){
            HashMap<String,String> response = new HashMap<>();
            response.put("message","An Error Occurred while fetching user from the database");
            response.put("error",String.valueOf(e));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
