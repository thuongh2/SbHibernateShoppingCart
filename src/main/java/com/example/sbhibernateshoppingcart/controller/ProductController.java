package com.example.sbhibernateshoppingcart.controller;

import com.example.sbhibernateshoppingcart.entity.Product;
import com.example.sbhibernateshoppingcart.dto.ProductDto;
import com.example.sbhibernateshoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/product/{productId}")
//    public Product getProductById(@PathVariable(name="productId") String code){
//        return productService.getProductById(code);
//    }
//
//    @GetMapping("/product")
//    public List<Product> getProductByCategory(@RequestParam(value="category") String id){
//        return productService.getProductByCategory(id);
//    }

    @GetMapping("/product/category/{name}")
    public List<Product> getProductByCategoryName(@PathVariable(value="name") String name){
        return productService.getProductByCategoryName(name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/product/save")
    public Product saveProduct(@ModelAttribute ProductDto product){
        return productService.saveProduct(product);

    }

//    @PostMapping("/product/update")
//    public Product updateProduct(@RequestBody Product product,
//                               @ModelAttribute(name = "imageFile")MultipartFile imageFile) throws IOException {
//        return  productService.updateProduct(product, imageFile);
//    }

//    @GetMapping("/product/delete/{productId}")
//    public void deleteProduct(@PathVariable(name="productId") String code) throws IOException {
//        productService.deleteProduct(code);
//    }
}
