package com.proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // 이름, 브랜드, 모델 등으로 검색하는 메서드
    List<Product> findByNameContainingOrBrandContainingOrModelContainingOrDescriptionContaining(String query, String query2, String query3, String query4);

    // 직접 작성한 검색 쿼리 메서드
    default List<Product> searchProducts(String query) {
        return findByNameContainingOrBrandContainingOrModelContainingOrDescriptionContaining(query, query, query, query);
    }
}
