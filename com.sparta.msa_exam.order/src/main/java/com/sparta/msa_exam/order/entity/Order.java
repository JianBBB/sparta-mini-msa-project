package com.sparta.msa_exam.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long orderId;

    private String name;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> productIds =  new ArrayList<>();


    public void addProductIds(OrderDetail orderDetail){
        this.productIds.add(orderDetail);
    }

    @Builder
    public Order(String name){
        this.name = name;
        this.productIds = new ArrayList<>();
    }
}
