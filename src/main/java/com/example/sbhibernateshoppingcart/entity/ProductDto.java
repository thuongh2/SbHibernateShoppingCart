package com.example.sbhibernateshoppingcart.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

@Data
public class ProductDto implements Serializable {
    private  String code;
    private  String name;
    private  double price;
    private String description;

    private MultipartFile imageFile ;

    private  Date createDate;
    private  String  categoryId;

    @Data
    public static class CategoryDto implements Serializable {
        private final String id;
        private final String name;
    }
}
