package com.toy.toyproject.api.service.comment.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChildCommentResponse {

    private Long id;

    private String content;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private Long parentId;

    private ChildCommentResponse(CommentResponse commentResponse) {
        this.id = commentResponse.getId();
        this.content = commentResponse.getContent();
        this.createdDate = commentResponse.getCreatedDate();
        this.modifiedDate = commentResponse.getModifiedDate();
        this.parentId = commentResponse.getParentId();
    }

    public static ChildCommentResponse from(CommentResponse commentResponse) {
        return new ChildCommentResponse(commentResponse);
    }

}
