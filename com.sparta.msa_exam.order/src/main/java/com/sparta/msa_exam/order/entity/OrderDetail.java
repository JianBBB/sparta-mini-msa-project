package com.sparta.msa_exam.order.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="order_detail")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long product_id;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    @Builder
    public OrderDetail(Long product_id, Order order){
        this.product_id=product_id;
        this.order = order;
    }
}
