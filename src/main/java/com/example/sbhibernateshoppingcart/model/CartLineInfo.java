package com.example.sbhibernateshoppingcart.model;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartLineInfo {
    private ProductInfo productInfo;
    private int quantity;

    public double getAmount() {
        return this.productInfo.getPrice() * this.quantity;
    }
}
