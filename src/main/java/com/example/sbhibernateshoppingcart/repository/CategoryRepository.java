package com.example.sbhibernateshoppingcart.repository;

import com.example.sbhibernateshoppingcart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findByName(String name);

}
