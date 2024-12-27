package com.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
