package com.example.sbhibernateshoppingcart.repository;

import com.example.sbhibernateshoppingcart.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, String> {
    Optional<Orders> findById(String id);
}
