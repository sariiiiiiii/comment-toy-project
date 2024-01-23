package com.toy.toyproject.api.service.posts.response;

import com.querydsl.core.annotations.QueryProjection;
import com.toy.toyproject.domain.comment.entity.Comment;
import com.toy.toyproject.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostWithCommentsResponse {

    private Long postId;
    private String postTitle;
    private String content;
    private Member member;
    private List<Comment> comments;

    @QueryProjection
    public PostWithCommentsResponse(Long postId, String postTitle, String content, Member member, List<Comment> comments) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.content = content;
        this.member = member;
        this.comments = comments;
    }

}
