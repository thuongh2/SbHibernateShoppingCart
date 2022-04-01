package com.example.sbhibernateshoppingcart.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @Column(name = "ID", length = 50, nullable = false)
    private String id;

    @Column(name = "Name", length = 255, nullable = false)
    private String name;
}
