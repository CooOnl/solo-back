package com.proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proj.model.Product;
import com.proj.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 차량 검색 기능
    public List<Product> search(String query) {
        // 차량 이름, 모델, 브랜드, 설명 등에서 검색 가능하도록 쿼리 로직 작성
        return productRepository.searchProducts(query);
    }

    // 모든 중고차 상품 조회
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    // 특정 ID로 상품 조회
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
