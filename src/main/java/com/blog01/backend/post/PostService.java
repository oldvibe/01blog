package com.blog01.backend.post;

import com.blog01.backend.user.User;
import com.blog01.backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void createPost(String content, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        Post post = Post.builder()
                .content(content)
                .author(user)
                .build();

        postRepository.save(post);
    }
    public Page<Post> getFeed(int page, int size) {
        return postRepository.findAllByOrderByCreatedAtDesc(
                PageRequest.of(page, size)
        );
    }

}
