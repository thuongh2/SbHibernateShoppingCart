package com.example.sbhibernateshoppingcart.service;

import com.example.sbhibernateshoppingcart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sbhibernateshoppingcart.entity.Orders;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Orders saveOrder(Orders order){
        return orderRepository.save(order);
    }

//    public Orders getOrders(){
//        return orderRepository.findById().orElse(null);
//    }
}
