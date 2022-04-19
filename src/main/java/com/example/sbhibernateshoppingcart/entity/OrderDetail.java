package com.example.sbhibernateshoppingcart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Order_Details")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK"))
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_USER_FK"))
    private User user;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    @Column(name = "Price", nullable = false)
    private double price; // giá của sản phẩm

    @Column(name = "Amount", nullable = false)
    private double amount; // tổng tiền = price * quantity

    @Column(name= "is_check", columnDefinition = "boolean default false")
    private boolean isCheck;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive;


}
