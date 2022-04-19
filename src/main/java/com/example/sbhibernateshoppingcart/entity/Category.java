package com.example.sbhibernateshoppingcart.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "category")
public class Category extends Auditable<String> implements Serializable {
    @Id
    @Column(name = "id", length = 50, nullable = false)
    private Long id;

    @Column(name = "Name", length = 255, nullable = false)
    private String name;

    //List image of product
    @Column(name = "product_id")
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

}
