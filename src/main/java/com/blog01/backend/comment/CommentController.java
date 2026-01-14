package com.blog01.backend.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{postId}/comments")
    public void comment(
            @PathVariable Long postId,
            @RequestBody String content,
            @AuthenticationPrincipal UserDetails user
    ) {
        commentService.addComment(postId, content, user.getUsername());
    }
}
