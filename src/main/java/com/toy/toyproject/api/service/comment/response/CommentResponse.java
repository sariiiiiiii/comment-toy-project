package com.toy.toyproject.api.service.comment.response;

import com.toy.toyproject.domain.comment.entity.Comment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CommentResponse {

    private Long id;

    private String name;

    private String content;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private Long parentId;

    private List<ChildCommentResponse> children = new ArrayList<>();

    @Builder
    public CommentResponse(Long id, String name, String content, LocalDateTime createdDate, LocalDateTime modifiedDate, Long parentId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.parentId = parentId;
    }

    public void updateParentId(Long id) {
        this.parentId = id;
    }

    private CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createdDate = comment.getCreatedDate();
        this.modifiedDate = comment.getModifiedDate();
    }

    public static CommentResponse toDto(Comment comment) {
        return new CommentResponse(comment);
    }

}
