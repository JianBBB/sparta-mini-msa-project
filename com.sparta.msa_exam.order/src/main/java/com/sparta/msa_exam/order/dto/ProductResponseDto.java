package com.sparta.msa_exam.order.dto;

import lombok.Getter;

@Getter
public class ProductResponseDto {
    private Long productId;
    private String name;
    private Integer supplyPrice;

    protected ProductResponseDto() {}

    public ProductResponseDto(Long productId, String name, Integer supplyPrice) {
        this.productId = productId;
        this.name = name;
        this.supplyPrice = supplyPrice;
    }
}
