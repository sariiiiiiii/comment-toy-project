package com.toy.toyproject.domain.post.entity;

import com.toy.toyproject.api.controller.posts.request.PostRequest;
import com.toy.toyproject.common.BaseTimeEntity;
import com.toy.toyproject.domain.comment.entity.Comment;
import com.toy.toyproject.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posts extends BaseTimeEntity {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Where(clause = "parent_id is null")
    @OneToMany(mappedBy = "posts", orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public void update(PostRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }

    public boolean validateMember(Member member) {
        return !this.member.equals(member);
    }

}
