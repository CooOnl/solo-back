package com.proj.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proj.model.Product;
import com.proj.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 전체 중고차 상품 목록 조회
    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    // 국산차 필터링
    @GetMapping("/domestic")
    public List<Product> getDomesticCars() {
        return productService.getAllProduct().stream()
                .filter(product -> !product.isImported())
                .collect(Collectors.toList());
    }

    // 수입차 필터링
    @GetMapping("/imported")
    public List<Product> getImportedCars() {
        return productService.getAllProduct().stream()
                .filter(product -> Boolean.TRUE.equals(product.isImported()))  // null-safe 필터링
                .collect(Collectors.toList());
    }


    // 검색 기능
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam("query") String query) {
        // query로 중고차 제품을 검색
        return productService.search(query);
    }

    // 특정 ID로 상품 조회
    @GetMapping("/{id}")
    public Product getProductById(@RequestParam("id") Long id) {
        return productService.getProductById(id);
    }
}
