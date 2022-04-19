package com.example.sbhibernateshoppingcart.repository;

import com.example.sbhibernateshoppingcart.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrdersId(Long id);
}
