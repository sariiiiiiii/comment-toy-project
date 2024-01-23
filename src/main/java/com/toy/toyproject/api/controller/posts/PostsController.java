package com.toy.toyproject.api.controller.posts;

import com.toy.toyproject.api.service.posts.PostsService;
import com.toy.toyproject.api.service.posts.response.PostsDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @GetMapping
    public List<PostsDetailResponse> findAll() {
        return postsService.findAll();
    }

    @GetMapping("/{id}")
    public PostsDetailResponse getAllCommentsByPostId(@PathVariable("id") final Long id) {
        return postsService.getAllCommentsByPostId(id);
    }

}
