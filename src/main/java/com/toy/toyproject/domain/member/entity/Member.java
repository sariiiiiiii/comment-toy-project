package com.toy.toyproject.domain.member.entity;

import com.toy.toyproject.common.BaseTimeEntity;
import com.toy.toyproject.domain.comment.entity.Comment;
import com.toy.toyproject.domain.post.entity.Posts;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Posts> posts;

    @OneToMany(mappedBy = "member")
    private List<Comment> comments;

    public Member(String name) {
        this.name = name;
    }

}
