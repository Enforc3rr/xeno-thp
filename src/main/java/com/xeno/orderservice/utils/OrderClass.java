package com.xeno.orderservice.utils;

import java.util.List;

public class OrderClass {
    private Long orderedBy;
    private int totalPrice;
    private List<Long> products;

    public OrderClass(Long orderedBy, int totalPrice, List<Long> products) {
        this.orderedBy = orderedBy;
        this.totalPrice = totalPrice;
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderClass{" +
                "orderedBy=" + orderedBy +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public OrderClass() {
    }

    public Long getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(Long orderedBy) {
        this.orderedBy = orderedBy;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }
}
