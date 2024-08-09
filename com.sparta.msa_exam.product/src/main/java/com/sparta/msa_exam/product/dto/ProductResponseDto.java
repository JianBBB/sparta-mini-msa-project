package com.sparta.msa_exam.product.dto;

import com.sparta.msa_exam.product.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponseDto {
    private Long productId;
    private String name;
    private Integer supplyPrice;

    protected ProductResponseDto() {}

    public ProductResponseDto(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.supplyPrice = product.getSupplyPrice();
    }
}
