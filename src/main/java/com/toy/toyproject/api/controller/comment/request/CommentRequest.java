package com.toy.toyproject.api.controller.comment.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentRequest {

    private Long postId;

    private Long parentId;

    private String content;

}
