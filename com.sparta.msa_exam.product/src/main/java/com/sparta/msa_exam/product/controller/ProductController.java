package com.sparta.msa_exam.product.controller;

import com.sparta.msa_exam.product.dto.ProductResponseDto;
import com.sparta.msa_exam.product.dto.ProductSaveRequestDto;
import com.sparta.msa_exam.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public void saveProduct(@RequestBody ProductSaveRequestDto req){
        productService.saveProduct(req);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getProducts(){
        return productService.getProducts();
    }

}
