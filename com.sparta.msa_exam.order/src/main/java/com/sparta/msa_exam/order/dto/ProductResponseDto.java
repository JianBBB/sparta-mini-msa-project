package com.sparta.msa_exam.order.dto;

import lombok.Getter;

@Getter
public class ProductResponseDto {
    private Long product_id;
    private String name;
    private Integer supply_price;

    protected ProductResponseDto() {}

    public ProductResponseDto(Long product_id, String name, Integer supply_price) {
        this.product_id = product_id;
        this.name = name;
        this.supply_price = supply_price;
    }
}
