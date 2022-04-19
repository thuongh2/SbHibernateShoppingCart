package com.example.sbhibernateshoppingcart.service;

import com.example.sbhibernateshoppingcart.entity.OrderDetail;
import com.example.sbhibernateshoppingcart.dto.OrderDetailDto;
import com.example.sbhibernateshoppingcart.repository.OrderDetailRepository;
import com.example.sbhibernateshoppingcart.repository.OrderRepository;
import com.example.sbhibernateshoppingcart.repository.ProductRepository;
import com.example.sbhibernateshoppingcart.utils.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void save(OrderDetailDto orderDetailDto) throws Exception {
        OrderDetail orderDetail = modelMapper.map(orderDetailDto, OrderDetail.class);
        orderDetail.setProduct(productRepository.findProductByCode(orderDetailDto.getProduct()));
        orderDetail.setOrders(orderRepository.findById(orderDetailDto.getOrders()).orElseThrow(() -> new Exception("Hư")));
        orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetailDto> getAllOrder(){
        List<OrderDetailDto> orderDetailDtos = ObjectMapperUtils.mapAll(orderDetailRepository.findAll(), OrderDetailDto.class);
        return  orderDetailDtos;
    }

    public List<OrderDetailDto> getOrder(Long ordersId){
        List<OrderDetailDto> orderDetailDtos = ObjectMapperUtils.mapAll(orderDetailRepository.findByOrdersId(ordersId), OrderDetailDto.class);
        return  orderDetailDtos;
    }
}
