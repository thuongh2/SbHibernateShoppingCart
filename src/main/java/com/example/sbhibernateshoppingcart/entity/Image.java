package com.example.sbhibernateshoppingcart.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "thumbnail", nullable = false)
    private String thumbnail;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name ="image")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Product product;

}
