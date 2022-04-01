package com.example.sbhibernateshoppingcart.service;

import com.example.sbhibernateshoppingcart.entity.OrderDetail;
import com.example.sbhibernateshoppingcart.entity.OrderDetailDto;
import com.example.sbhibernateshoppingcart.entity.Orders;
import com.example.sbhibernateshoppingcart.repository.OrderDetailRepository;
import com.example.sbhibernateshoppingcart.repository.OrderRepository;
import com.example.sbhibernateshoppingcart.repository.ProductRepository;
import com.example.sbhibernateshoppingcart.utils.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;

    public void save(OrderDetailDto orderDetailDto){
        OrderDetail orderDetail = modelMapper.map(orderDetailDto, OrderDetail.class);
        orderDetail.setProduct(productRepository.findProductByCode(orderDetailDto.getProduct().getCode()));
        orderDetail.setOrders(orderRepository.findById(orderDetailDto.getOrders().getId()).get());
        orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetailDto> getAllOrder(){
        List<OrderDetailDto> orderDetailDtos = ObjectMapperUtils.mapAll(orderDetailRepository.findAll(), OrderDetailDto.class);
        return  orderDetailDtos;
    }

    public List<OrderDetailDto> getOrder(String ordersId){
        List<OrderDetailDto> orderDetailDtos = ObjectMapperUtils.mapAll(orderDetailRepository.findByOrdersId(ordersId), OrderDetailDto.class);
        return  orderDetailDtos;
    }
}
