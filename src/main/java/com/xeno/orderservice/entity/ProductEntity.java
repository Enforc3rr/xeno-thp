package com.xeno.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    private Long productID;
    @Column(name = "productName")
    private String productName;
    @Column(name = "productCategory")
    private String productCategory;
    @Column(name = "productPrice")
    private Integer productPrice;

    public ProductEntity() {
    }

    public ProductEntity(String productName, String productCategory, Integer productPrice) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }

    @JsonIgnore
    @ManyToMany(targetEntity = OrderEntity.class,
            cascade = { CascadeType.DETACH, CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH}
            ,fetch = FetchType.LAZY)
    @JoinTable(
            name="order_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private Set<OrderEntity> orderEntity;


    @Override
    public String toString() {
        return "ProductEntity{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}
