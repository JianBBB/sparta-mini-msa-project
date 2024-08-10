package com.sparta.msa_exam.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductSaveRequestDto {
    private String name;
    private Integer supply_price;

    public ProductSaveRequestDto(String name, Integer supply_price) {
        this.name=name;
        this.supply_price=supply_price;
    }

}
