package com.example.sbhibernateshoppingcart.controller;


import com.example.sbhibernateshoppingcart.entity.Category;
import com.example.sbhibernateshoppingcart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

}
