package com.toy.toyproject.domain.post.repository;

import com.toy.toyproject.domain.post.entity.Posts;

import java.util.List;
import java.util.Optional;

public interface PostsRepositoryCustom {

    List<Posts> findAllPostsWithComments();

    Optional<Posts> findByPostId(Long id);

}
