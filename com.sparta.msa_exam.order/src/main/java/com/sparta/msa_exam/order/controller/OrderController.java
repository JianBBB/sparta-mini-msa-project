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

    @PutMapping("/order/{order_id}")
    public void putOrderDetail(@PathVariable Long order_id, @RequestBody ProductRequestDto request){
        orderService.putOrderDetail(order_id,request);

    }

    @GetMapping("/order/{order_id}")
    public OrderResponseDto getOrder(@PathVariable Long order_id){
        return orderService.getOrder(order_id);
    }

}
