package com.toy.toyproject.domain.comment.entity;

import com.toy.toyproject.api.controller.comment.request.CommentRequest;
import com.toy.toyproject.common.BaseTimeEntity;
import com.toy.toyproject.domain.member.entity.Member;
import com.toy.toyproject.domain.post.entity.Posts;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Posts posts;

    @Column(nullable = false)
    private String content;

    /**
     * Comment 라는 엔티티 하나에 부모 Comment, 자식 Comment(List) 를 넣어서 계층형 테이블로 구성
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public void update(CommentRequest request) {
        this.content = request.getContent();
    }

    public void updateParent(Comment parent) {
        this.parent = parent;
    }

    public boolean validateMember(Member member) {
        return !this.member.equals(member);
    }

    @Builder
    public Comment(Member member, Posts posts, String content) {
        this.member = member;
        this.posts = posts;
        this.content = content;
    }

}
