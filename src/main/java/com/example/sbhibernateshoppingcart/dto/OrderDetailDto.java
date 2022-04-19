package com.example.sbhibernateshoppingcart.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetailDto implements Serializable {
    private Long id;
    private Long orders;
    private Long product;
    private int quantity;
    private double price;
    private double amount;

}
