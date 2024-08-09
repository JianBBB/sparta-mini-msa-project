package com.sparta.msa_exam.order.controller;


import com.sparta.msa_exam.order.dto.OrderResponseDto;
import com.sparta.msa_exam.order.dto.OrderSaveRequestDto;
import com.sparta.msa_exam.order.dto.ProductRequestDto;
import com.sparta.msa_exam.order.service.OrderService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public void saveOrder(@RequestBody OrderSaveRequestDto request){
        orderService.saveOrder(request);
    }

    @PutMapping("/order/{orderId}")
    public void putOrderDetail(@PathVariable Long orderId, @RequestBody ProductRequestDto request){
        orderService.putOrderDetail(orderId,request);

    }

    @GetMapping("/order/{orderId}")
    public OrderResponseDto getOrder(@PathVariable Long orderId){
        return orderService.getOrder(orderId);
    }

}
