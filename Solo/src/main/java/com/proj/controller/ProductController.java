package com.proj.controller;

import java.util.List; 

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proj.model.Product;
import com.proj.service.ProductService;


@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class ProductController {
	
	
	
	// 검색창 기능 구현
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }
    
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam("query") String query) {
        return productService.search(query);
    }
    
    
}
