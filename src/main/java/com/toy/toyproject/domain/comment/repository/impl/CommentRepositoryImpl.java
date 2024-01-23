package com.toy.toyproject.domain.comment.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.toyproject.domain.comment.entity.Comment;
import com.toy.toyproject.domain.comment.repository.CommentRepositoryCustom;
import com.toy.toyproject.domain.post.entity.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.toy.toyproject.domain.comment.entity.QComment.comment;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    /**
     * 게시글에 속한 댓글들을 조회합니다.
     * 부모 댓글은 부모의 ID를 기준으로 오름차순 정렬하며, null 경우는 가장 먼저 표시됩니다.
     * 댓글의 작성일 기준으로 오름차순 정렬합니다.
     *
     * @param posts 조회할 게시글
     * @return 조회된 댓글 리스트
     */
    @Override
    public List<Comment> findAllCommentsByPostId(Posts posts) {
        return queryFactory.selectFrom(comment)
                .leftJoin(comment.parent)
                .fetchJoin() // 댓글의 부모 댓글도 함께 즉시로딩
                .where(comment.posts.id.eq(posts.getId()))
                .orderBy(comment.parent.id.asc().nullsFirst(), comment.createdDate.asc())
                .fetch();
    }

}
