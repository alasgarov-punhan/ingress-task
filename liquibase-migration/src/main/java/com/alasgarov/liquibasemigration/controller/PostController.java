package com.alasgarov.liquibasemigration.controller;

import com.alasgarov.liquibasemigration.dto.CreatePostRequest;
import com.alasgarov.liquibasemigration.dto.PostDto;
import com.alasgarov.liquibasemigration.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    List<PostDto> getAllPost(){
        return postService.getAllPost();
    }

    @PostMapping
    PostDto createPost(@Valid @RequestBody CreatePostRequest request){
        return postService.createPost(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePostById(@PathVariable Long id){
        postService.deletePost(id);
    }
}
