package com.sparta.msa_exam.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderSaveRequestDto {
    private String name;

    public OrderSaveRequestDto(String name) {
        this.name = name;
    }
}
