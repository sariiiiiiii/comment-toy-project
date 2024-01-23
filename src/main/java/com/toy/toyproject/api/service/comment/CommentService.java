package com.toy.toyproject.api.service.comment;

import com.toy.toyproject.api.controller.comment.request.CommentRequest;
import com.toy.toyproject.api.service.comment.response.CommentResponse;
import com.toy.toyproject.domain.comment.entity.Comment;
import com.toy.toyproject.domain.comment.repository.CommentRepository;
import com.toy.toyproject.domain.post.entity.Posts;
import com.toy.toyproject.domain.post.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final PostsRepository postsRepository;

    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponse createComment(final CommentRequest request) {
        Posts post = postsRepository.findByPostId(request.getPostId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글 id 입니다"));

        Comment parent = null;
        // 자식 댓글인 경우
        if (request.getParentId() != null) {
            parent = commentRepository.findById(request.getParentId())
                    .orElseThrow(() -> new RuntimeException("존재하지 않는 댓글 id 입니다"));

            // 부모댓글의 게시글 번호와 자식댓글의 게시글 번호 같은지 체크하기
            if (!parent.getPosts().getId().equals(request.getPostId())) {
                throw new RuntimeException("부모댓글과 자식댓글의 게시글 번호가 일치하지 않습니다");
            }
        }

        Comment comment = Comment.builder()
                .member(post.getMember())
                .posts(post)
                .content(request.getContent())
                .build();

        if (parent != null) {
            // 부모 댓글이 있을 경우
            comment.updateParent(parent);
        }

        commentRepository.save(comment);

        CommentResponse.CommentResponseBuilder commentResponseBuilder = CommentResponse.builder()
                .id(comment.getId())
                .name(comment.getMember().getName())
                .content(comment.getContent())
                .createdDate(comment.getCreatedDate())
                .modifiedDate(comment.getModifiedDate());

        if (parent != null) {
            commentResponseBuilder
                    .parentId(comment.getParent().getId());
        }
        return commentResponseBuilder.build();
    }

}
