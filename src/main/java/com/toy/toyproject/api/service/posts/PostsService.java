package com.toy.toyproject.api.service.posts;

import com.toy.toyproject.api.service.comment.response.ChildCommentResponse;
import com.toy.toyproject.api.service.comment.response.CommentResponse;
import com.toy.toyproject.api.service.posts.response.PostWithCommentsResponse;
import com.toy.toyproject.api.service.posts.response.PostsDetailResponse;
import com.toy.toyproject.domain.comment.entity.Comment;
import com.toy.toyproject.domain.comment.repository.CommentRepository;
import com.toy.toyproject.domain.post.entity.Posts;
import com.toy.toyproject.domain.post.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    private final CommentRepository commentRepository;

    public List<PostsDetailResponse> findAll() {
        List<Posts> posts = postsRepository.findAllPostsWithComments();

        List<PostsDetailResponse> postsDetailResponses = new ArrayList<>();

        for (Posts post : posts) {
            List<Comment> comments = post.getComments();

            List<CommentResponse> commentResponses = new ArrayList<>();

            Map<Long, CommentResponse> map = new HashMap<>();

            comments.forEach(comment -> {
                CommentResponse commentResponse = CommentResponse.toDto(comment);
                if (comment.getParent() != null) {
                    commentResponse.updateParentId(comment.getParent().getId());
                }
                map.put(commentResponse.getId(), commentResponse);
                if (comment.getParent() != null) {
                    map.get(comment.getParent().getId()).getChildren().add(ChildCommentResponse.from(commentResponse)); // 대댓글은 ChildCommentResponse 객체
                } else {
                    commentResponses.add(commentResponse); // 부모댓글은 CommentResponse 객체
                }
            });
            postsDetailResponses.add(PostsDetailResponse.of(post.getId(), post.getMember().getName(), commentResponses));
        }
        return postsDetailResponses;
    }

    public PostsDetailResponse getAllCommentsByPostId(Long postId) {
        Posts posts = postsRepository.findByPostId(postId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글 id 입니다"));

        List<Comment> comments = commentRepository.findAllCommentsByPostId(posts);

        List<CommentResponse> commentResponses = new ArrayList<>();

        Map<Long, CommentResponse> map = new HashMap<>();

        comments.forEach(comment -> {
            CommentResponse commentResponse = CommentResponse.toDto(comment);
            if (comment.getParent() != null) {
                commentResponse.updateParentId(comment.getParent().getId());
            }
            map.put(commentResponse.getId(), commentResponse);
            if (comment.getParent() != null) {
                map.get(comment.getParent().getId()).getChildren().add(ChildCommentResponse.from(commentResponse)); // 대댓글은 ChildCommentResponse 객체
            } else {
                commentResponses.add(commentResponse); // 부모댓글은 CommentResponse 객체
            }
        });

        return PostsDetailResponse.of(posts.getId(), posts.getMember().getName(), commentResponses);
    }

}
