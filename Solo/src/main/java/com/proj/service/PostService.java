package com.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.exception.PostNotFoundException;
import com.proj.model.Post;
import com.proj.repository.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
    

    public Post getPostById(Long id) {
        try {
            return postRepository.findById(id)
                    .orElseThrow(() -> new PostNotFoundException("게시글을 찾을 수 없습니다."));
        } catch (Exception e) {
            System.err.println("Error occurred while fetching post by id: " + e.getMessage());
            throw e; // 예외를 다시 던져서 컨트롤러에서 처리
        }
    }

}
