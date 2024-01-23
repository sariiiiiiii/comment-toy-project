package com.toy.toyproject.api.controller.posts.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostRequest {

    private String title;

    private String content;

}
