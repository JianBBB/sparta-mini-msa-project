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
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @CachePut(cacheNames = "orderCache", key="#orderId")
    public OrderResponseDto putOrderDetail(Long orderId, ProductRequestDto request) {
        Long product_id = request.getProduct_id();
        if(!productClient.getProducts().stream().anyMatch(product -> product.getProduct_id().equals(product_id))){
            throw new RuntimeException("제공해주신 product_id - "+ product_id + "는 존재하지 않는 상품입니다.");
        }

        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new RuntimeException("제공해주신 orderId - "+ orderId + "는 존재하지 않는 주문입니다.")
        );

        OrderDetail orderDetail = orderDetailRepository.save(OrderDetail.builder()
                .product_id(product_id)
                .order(order)
                .build()
        );

        order.addproduct_ids(orderDetail);

        return  new OrderResponseDto(order.getOrderId(),
                order.getProduct_ids().stream()
                        .map(od -> od.getProduct_id().intValue())
                        .toList()
        );
    }

    @Cacheable(cacheNames="orderCache", key="#orderId")
    public OrderResponseDto getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                ()->new RuntimeException("제공해주신 orderId - "+ orderId + "는 존재하지 않는 주문입니다.")
        );

       return  new OrderResponseDto(order.getOrderId(),
                order.getProduct_ids().stream()
                        .map(orderDetail -> orderDetail.getProduct_id().intValue())
                        .toList()
        );
    }
}
