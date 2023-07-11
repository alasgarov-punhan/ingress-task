package com.alasgarov.mspost.controller;

import com.alasgarov.mspost.dto.CreatePostRequest;
import com.alasgarov.mspost.dto.PostDto;
import com.alasgarov.mspost.service.PostService;
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


    @GetMapping("/hi")
    String sayHi(){
        return "hi";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePostById(@PathVariable Long id){
        postService.deletePost(id);
    }
}
