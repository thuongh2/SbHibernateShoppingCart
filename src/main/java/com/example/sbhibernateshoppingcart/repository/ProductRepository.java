package com.example.sbhibernateshoppingcart.repository;

import com.example.sbhibernateshoppingcart.entity.Category;
import com.example.sbhibernateshoppingcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByCategory(Category category);

    Product findProductByCode(String code);
}