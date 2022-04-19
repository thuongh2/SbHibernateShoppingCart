package com.example.sbhibernateshoppingcart.controller;

import com.example.sbhibernateshoppingcart.dto.OrderDetailDto;
import com.example.sbhibernateshoppingcart.entity.Orders;
import com.example.sbhibernateshoppingcart.service.OrderDetailService;
import com.example.sbhibernateshoppingcart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderService orderService;

    @PostMapping("save/order")
    public Orders saveOrder(@RequestBody Orders orders){
        return orderService.saveOrder(orders);
    }

    @PostMapping("save/addtocard")
    public void saveOrderDetail(@ModelAttribute OrderDetailDto orderDetails) throws Exception {
        orderDetailService.save(orderDetails);
    }

//    @GetMapping("/order")
//    public Orders getOrders(){
//        return orderService.getOrders();
//    }

    //ADMIN
    @GetMapping("/order/all")
    public List<OrderDetailDto> getAll(){
        return orderDetailService.getAllOrder();
    }

//    //USER
//    @GetMapping("/order/{orderId}")
//    public List<OrderDetailDto> getOrderById(@PathVariable String orderId){
//        return orderDetailService.getOrder(orderId);
//    }




}
