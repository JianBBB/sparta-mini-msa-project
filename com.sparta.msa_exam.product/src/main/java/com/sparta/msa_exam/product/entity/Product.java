package com.sparta.msa_exam.product.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long product_id;

    @Column(nullable = false)
    private String name;
    @Column(name="supply_price", nullable = false)
    private Integer supply_price;

    @Builder
    public Product(String name, Integer supply_price) {
        this.name=name;
        this.supply_price =supply_price;
    }

}
