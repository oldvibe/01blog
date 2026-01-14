package com.blog01.backend.post;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void createPost(
            @RequestBody String content,
            @AuthenticationPrincipal UserDetails user
    ) {
        postService.createPost(content, user.getUsername());
    }
    
    @GetMapping
    public Page<Post> feed(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return postService.getFeed(page, size);
    }

}
