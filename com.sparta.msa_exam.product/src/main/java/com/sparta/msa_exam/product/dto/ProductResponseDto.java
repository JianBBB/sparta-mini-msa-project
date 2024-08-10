package com.sparta.msa_exam.product.dto;

import com.sparta.msa_exam.product.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponseDto {
    private Long product_id;
    private String name;
    private Integer supply_price;

    protected ProductResponseDto() {}

    public ProductResponseDto(Product product) {
        this.product_id = product.getProduct_id();
        this.name = product.getName();
        this.supply_price = product.getSupply_price();
    }
}
