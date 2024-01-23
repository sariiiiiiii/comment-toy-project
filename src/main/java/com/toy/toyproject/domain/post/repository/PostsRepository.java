package com.toy.toyproject.domain.post.repository;

import com.toy.toyproject.domain.post.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>, PostsRepositoryCustom {
}
