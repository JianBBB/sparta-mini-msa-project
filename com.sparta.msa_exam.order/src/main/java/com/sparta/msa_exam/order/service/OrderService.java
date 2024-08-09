package com.sparta.msa_exam.order.service;


import com.sparta.msa_exam.order.dto.OrderResponseDto;
import com.sparta.msa_exam.order.dto.OrderSaveRequestDto;
import com.sparta.msa_exam.order.dto.ProductRequestDto;
import com.sparta.msa_exam.order.entity.Order;
import com.sparta.msa_exam.order.entity.OrderDetail;
import com.sparta.msa_exam.order.feign.ProductClient;
import com.sparta.msa_exam.order.repository.OrderDetailRepository;
import com.sparta.msa_exam.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductClient productClient;

    public void saveOrder(OrderSaveRequestDto request) {
        orderRepository.save(Order.builder()
                .name(request.getName())
                .build()
        );
    }

    @Transactional
    public void putOrderDetail(Long orderId, ProductRequestDto request) {
        Long productId = request.getProductId();
        if(!productClient.getProducts().stream().anyMatch(product -> product.getProductId().equals(productId))){
            throw new RuntimeException("제공해주신 productId - "+ productId + "는 존재하지 않는 상품입니다.");
        }

        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new RuntimeException("제공해주신 orderId - "+ orderId + "는 존재하지 않는 주문입니다.")
        );

        OrderDetail orderDetail = orderDetailRepository.save(OrderDetail.builder()
                .productId(productId)
                .order(order)
                .build()
        );

        order.addProductIds(orderDetail);
    }

    public OrderResponseDto getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                ()->new RuntimeException("제공해주신 orderId - "+ orderId + "는 존재하지 않는 주문입니다.")
        );

       return  new OrderResponseDto(order.getOrderId(),
                order.getProductIds().stream()
                        .map(orderDetail -> orderDetail.getProductId().intValue())
                        .toList()
        );
    }
}
