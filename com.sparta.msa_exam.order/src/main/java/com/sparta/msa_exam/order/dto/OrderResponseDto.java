package com.sparta.msa_exam.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
public class OrderResponseDto implements Serializable {
    private Long orderId;
    private List<Integer> productIds;

    public OrderResponseDto(Long orderId, List<Integer> productIds ){
        this.orderId=orderId;
        this.productIds = productIds;
    }
}
