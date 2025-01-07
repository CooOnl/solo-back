package com.proj.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.exception.PostNotFoundException;
import com.proj.model.Post;
import com.proj.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/apis")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/list")
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }

//    @GetMapping("/detail/{id}")
//    public ResponseEntity<Object> getPostById(@PathVariable Long id) {
//        try {
//            Post post = postService.getPostById(id);
//            if (post == null) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                                     .body("게시글을 찾을 수 없습니다.");  // 404 응답
//            }
//            return ResponseEntity.ok(post);
//        } catch (PostNotFoundException e) {
//            // 특정 예외를 처리
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                                 .body("게시글을 찾을 수 없습니다.");  // 404 응답
//        } catch (Exception e) {
//            // 예외 메시지와 함께 500 Internal Server Error 처리
//            log.error("서버 오류: ", e);  // 오류 로그를 기록하여 원인 추적 가능
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                                 .body("서버 오류가 발생했습니다. 오류 메시지: " + e.getMessage());
//        }
//    }



    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        post.setDate(LocalDateTime.now());
        return postService.createPost(post);
    }

    // 예외 처리 핸들러
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<String> handlePostNotFoundException(PostNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
