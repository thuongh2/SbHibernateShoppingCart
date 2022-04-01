package com.example.sbhibernateshoppingcart.service;

import com.example.sbhibernateshoppingcart.entity.Category;
import com.example.sbhibernateshoppingcart.entity.Product;
import com.example.sbhibernateshoppingcart.entity.ProductDto;
import com.example.sbhibernateshoppingcart.repository.CategoryRepository;
import com.example.sbhibernateshoppingcart.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private ModelMapper modelMapper;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(String code) {
        return productRepository.findProductByCode(code);
    }

    public List<Product> getProductByCategory(String category_id){
        Category category = categoryRepository.findById(category_id).get();
        return  productRepository.findByCategory(category);
    }

    public List<Product> getProductByCategoryName(String name){
        Category category = categoryRepository.findByName(name);
        return  productRepository.findByCategory(category);
    }

    public Product saveProduct(ProductDto product){
        String imageProduct = "";

        if(product.getImageFile() != null) {
            imageProduct = cloudinaryService.uploadFile(product.getImageFile());

        }

        Product product1 = modelMapper.map(product, Product.class);

        Category category = categoryRepository.findById(String.valueOf(product.getCategoryId())).get();
        product1.setCategory(category);
        product1.setImage(imageProduct);

        return productRepository.save(product1);
    }

    public Product updateProduct(Product product, MultipartFile imageFile) throws IOException {
        Product productUpdate = productRepository.findProductByCode(product.getCode());
        if(productUpdate == null){
            throw new IOException("Product not found");
        }

        if(imageFile != null){
            String imageProduct = cloudinaryService.uploadFile(imageFile);
            productUpdate.setImage(imageProduct);
        }

        productUpdate.setCode(product.getCode());
        productUpdate.setName(product.getName());
        productUpdate.setPrice(product.getPrice());
        productUpdate.setCreateDate(productUpdate.getCreateDate());
        productUpdate.setCategory(product.getCategory());

        return productRepository.save(productUpdate);
    }

    public void deleteProduct(String productId) throws IOException {
        Product product = productRepository.findProductByCode(productId);

        if(product == null){
            throw new IOException("Product not found");
        }

        productRepository.delete(product);
    }

}
