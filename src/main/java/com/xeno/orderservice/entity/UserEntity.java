package com.xeno.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long userID;
    private String name;
    private String email;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL,orphanRemoval = true , fetch = FetchType.LAZY)
    private List<OrderEntity> orderEntities;

    public UserEntity() {
    }

    public UserEntity(String name, String email, String address, List<OrderEntity> orderEntities) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.orderEntities = orderEntities;
    }
    public UserEntity(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' + " }" ;
    }

    public List<OrderEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(List<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
