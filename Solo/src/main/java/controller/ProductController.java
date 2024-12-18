package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Product;
import service.ProductService;

@RestController
@RequestMapping("/api/products") // API의 기본 URL
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {

    @Autowired
    private ProductService productService;

    // 검색 API: /api/products/search
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String query) {
        return productService.searchProducts(query);
    }
}
