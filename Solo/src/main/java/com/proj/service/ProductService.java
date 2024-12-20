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

    public List<Product> search(String query) {
        return productRepository.searchProducts(query);
    }
    public List<Product> getAllProduct(){
    	return productRepository.findAll();
    }
}
