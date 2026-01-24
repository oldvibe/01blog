package com.blog01.backend.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponse {

    private Long id;
    private String content;
    private String author;
    private boolean owner;
    private LocalDateTime createdAt;
}
