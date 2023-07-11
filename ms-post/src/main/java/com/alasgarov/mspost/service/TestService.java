package com.alasgarov.mspost.service;

import com.alasgarov.mspost.model.Post;
import com.alasgarov.mspost.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final PostRepository postRepository;
    public void test(){
        System.out.println("Scheduler is running");
    }
    public void savePostTest(){
        savePost();
    }

    @Transactional
    public void savePost(){
        Post post = Post.builder()
                .title("title")
                .body("body")
                .userId(1L)
                .build();
        postRepository.save(post);
        throwException();
    }

    public void throwException(){
        throw new RuntimeException();
    }
}

