package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.ProductResponseDto;
import com.sparta.msa_exam.product.dto.ProductSaveRequestDto;
import com.sparta.msa_exam.product.entity.Product;
import com.sparta.msa_exam.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void saveProduct(ProductSaveRequestDto req) {
        Product product = Product.builder()
                .name(req.getName())
                .supply_price(req.getSupply_price())
                .build();

        productRepository.save(product);
    }

    public List<ProductResponseDto> getProducts() {
        return productRepository.findAll()
                                .stream()
                                .map(ProductResponseDto::new)
                                .collect(Collectors.toList());
    }
}
