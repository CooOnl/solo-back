package com.proj.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String name;
    
    @JsonFormat(pattern = "yyyy-MM-dd / HH:mm분")  // 날짜 포맷 지정
    private LocalDateTime date;

    // 기본 생성자
//    public Post() {
//    }

    // 생성자
//    public Post(Long id ,String title, String content,String username, LocalDateTime date) {
//        this.title = title;
//        this.content = content;
//        this.date = date;
//        this.username = username;
//    }

    // Getter & Setter 메서드들
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//    
//    public String getUsername() {
//    	return username;
//    }
//    
//    public String setUsername(String username) {
//    	this.username = username;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public LocalDateTime getDate() {
//        return date;
//    }

//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }

    // 날짜를 포맷팅해서 반환하는 메서드
    public String getFormattedDate() {
        if (this.date != null) {
            return this.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd / HH:mm분"));
        }
        return "";
    }
}
