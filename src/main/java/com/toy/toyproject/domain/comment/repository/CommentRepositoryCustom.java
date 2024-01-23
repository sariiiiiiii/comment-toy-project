package com.toy.toyproject.domain.comment.repository;

import com.toy.toyproject.domain.comment.entity.Comment;
import com.toy.toyproject.domain.post.entity.Posts;

import java.util.List;

public interface CommentRepositoryCustom {

    List<Comment> findAllCommentsByPostId(Posts posts);

}
