package com.xeno.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;
    private int totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity userEntity;

    @ManyToMany(targetEntity = ProductEntity.class,
            cascade = { CascadeType.DETACH, CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH}
            ,fetch = FetchType.LAZY)
    @JoinTable(
            name="order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<ProductEntity> productEntities;

    public OrderEntity() {
    }

    public OrderEntity(int totalPrice, UserEntity userEntity, Set<ProductEntity> productEntities) {
        this.totalPrice = totalPrice;
        this.userEntity = userEntity;
        this.productEntities = productEntities;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderID=" + orderID +
                ", totalPrice=" + totalPrice +
                ", userEntity=" + userEntity +
                ", productEntities=" + productEntities +
                '}';
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Set<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(Set<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }

}
