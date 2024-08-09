package com.sparta.msa_exam.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductSaveRequestDto {
    private String name;
    private Integer supplyPrice;

    public ProductSaveRequestDto(String name, Integer supplyPrice) {
        this.name=name;
        this.supplyPrice=supplyPrice;
    }

}
