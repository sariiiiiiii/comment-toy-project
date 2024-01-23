package com.toy.toyproject.domain.post.repository.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.toyproject.api.service.posts.response.PostWithCommentsResponse;
import com.toy.toyproject.api.service.posts.response.QPostWithCommentsResponse;
import com.toy.toyproject.domain.comment.entity.Comment;
import com.toy.toyproject.domain.comment.entity.QComment;
import com.toy.toyproject.domain.post.entity.Posts;
import com.toy.toyproject.domain.post.repository.PostsRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.toy.toyproject.domain.comment.entity.QComment.comment;
import static com.toy.toyproject.domain.member.entity.QMember.member;
import static com.toy.toyproject.domain.post.entity.QPosts.posts;

@Repository
@RequiredArgsConstructor
public class PostsRepositoryImpl implements PostsRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Posts> findAllPostsWithComments() {
        return queryFactory.selectFrom(posts)
                .leftJoin(posts.member, member)
                .fetchJoin()
                .leftJoin(posts.comments, comment)
                .fetchJoin()
                .distinct()
                .orderBy(posts.id.asc())
                .fetch();
    }

    @Override
    public Optional<Posts> findByPostId(Long id) {
        return Optional.ofNullable(queryFactory.selectFrom(posts)
                .where(posts.id.eq(id))
                .leftJoin(posts.member, member)
                .fetchJoin()
                .fetchOne());
    }

}
