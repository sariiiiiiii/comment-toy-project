-- member
INSERT INTO MEMBER
(`member_id`, `name`, `created_date`, `modified_date`) VALUES (1, '홍길동', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO MEMBER
(`member_id`, `name`, `created_date`, `modified_date`) VALUES (2, '김철수', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- posts
INSERT INTO POSTS
(`post_id`, `content`, `title`, `member_id`, `created_date`, `modified_date`) VALUES (1, '게시글 1번 입니다', '게시글 1번', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO POSTS
(`post_id`, `content`, `title`, `member_id`, `created_date`, `modified_date`) VALUES (2, '게시글 2번 입니다', '게시글 2번', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- comment
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (1, '1번 게시글의 1번 댓글 입니다', 1, null, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (2, '1번 게시글의 1번 댓글의 1번 대댓글입니다', 2, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (3, '1번 게시글의 1번 댓글의 2번 대댓글입니다', 1, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (4, '1번 게시글의 1번 댓글의 3번 대댓글입니다', 2, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (5, '1번 게시글의 2번 댓글 입니다', 1, null, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (6, '1번 게시글의 2번 댓글의 1번 대댓글입니다', 2, 5, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (7, '1번 게시글의 2번 댓글의 2번 대댓글입니다', 1, 5, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (8, '2번 게시글의 1번 댓글 입니다', 2, null, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (9, '2번 게시글의 1번 댓글의 1번 대댓글입니다', 1, 8, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (10, '2번 게시글의 1번 댓글의 2번 대댓글입니다', 2, 8, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (11, '2번 게시글의 1번 댓글의 3번 대댓글입니다', 1, 8, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (12, '2번 게시글의 2번 댓글 입니다', 2, null, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO COMMENT
(`id`, `content`, `member_id`, `parent_id`, `post_id`, `created_date`, `modified_date`) VALUES (13, '2번 게시글의 2번 댓글의 1번 대댓글입니다', 1, 12, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);