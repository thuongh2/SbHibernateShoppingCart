package com.example.sbhibernateshoppingcart.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetailDto implements Serializable {
    private String id;
    private OrdersDto orders;
    private ProductDto1 product;
    private int quantity;
    private double price;
    private double amount;

    @Data
    public static class OrdersDto implements Serializable {
        private String id;
        private String customerName;
    }

    @Data
    public static class ProductDto1 implements Serializable {
        private String code;
        private String name;
    }
}
