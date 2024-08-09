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
    private Long productId;

    @Column(nullable = false)
    private String name;
    @Column(name="supply_price", nullable = false)
    private Integer supplyPrice;

    @Builder
    public Product(String name, Integer supplyPrice) {
        this.name=name;
        this.supplyPrice =supplyPrice;
    }

}
