package com.toy.toyproject.api.controller.comment;

import com.toy.toyproject.api.controller.comment.request.CommentRequest;
import com.toy.toyproject.api.service.comment.CommentService;
import com.toy.toyproject.api.service.comment.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponse> createComment(@RequestBody final CommentRequest request) {
        return ResponseEntity.ok(commentService.createComment(request));
    }

}
