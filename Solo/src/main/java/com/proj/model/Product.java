package com.proj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")  // 테이블 이름은 'products'로 설정
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;           // 차량명
    private String description;    // 차량 설명
    private Double price;          // 가격
    private String brand;          // 브랜드
    private String model;          // 모델명
    private int year;              // 연식
    private int mileage;           // 주행거리
    private String fuelType;       // 연료 유형 (가솔린, 디젤 등)
    private String transmission;   // 변속기 (자동, 수동 등)
    private String color;          // 차량 색상
    private String imageUrl;       // 차량 이미지 URL (선택 사항)
    private boolean isImported;

    // 추가적인 생성자나 메서드가 필요하면 여기에 추가할 수 있습니다.
}
