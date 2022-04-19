package com.example.sbhibernateshoppingcart.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

@Data
public class ProductDto implements Serializable {
    private  Long code;
    private  String name;
    private  double price;
    private String description;

    private MultipartFile imageFile ;
    private String size;
    private  Date createDate;
    private  Long  categoryId;

    @Data
    public static class CategoryDto implements Serializable {
        private final Long id;
        private final String name;
    }
}
