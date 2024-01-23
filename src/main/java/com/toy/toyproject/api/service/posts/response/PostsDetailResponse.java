package com.toy.toyproject.api.service.posts.response;

import com.toy.toyproject.api.service.comment.response.CommentResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostsDetailResponse {

    private Long postId;

    private String name;

    private List<CommentResponse> commentResponses;

    public static PostsDetailResponse of(Long postId, String name, List<CommentResponse> commentResponses) {
        return new PostsDetailResponse(postId, name, commentResponses);
    }

}
