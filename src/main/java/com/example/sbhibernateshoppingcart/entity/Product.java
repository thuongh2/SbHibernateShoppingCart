package com.example.sbhibernateshoppingcart.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product extends Auditable<String> implements Serializable {

    // id and auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //name of product
    @Column(name = "name", length = 255, nullable = false)
    @NonNull
    private String name;
    // description and notblank
    @Column(name = "Description", nullable = true, columnDefinition = "TEXT")
    @NotBlank(message = "description not blank")
    private String description;

    @Column(name = "Price", nullable = false)
    @Min(value = 0, message = "price is positive")
    private double price;

    @Column(name = "quantity", nullable = false)
    @Min(value = 0, message = "quantity is positive")
    private int quantity;

    //List image of product
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image> image;

    //size image of product
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Size> sizes;

    // String of size: "32, 33, 34, 35"
    @Column(name= "Size", nullable = true)
    private String size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive;

}
