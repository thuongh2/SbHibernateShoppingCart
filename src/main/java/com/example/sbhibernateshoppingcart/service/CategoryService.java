package com.example.sbhibernateshoppingcart.service;

import com.example.sbhibernateshoppingcart.entity.Category;
import com.example.sbhibernateshoppingcart.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }


}
