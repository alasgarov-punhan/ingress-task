package com.alasgarov.simplerestapi.controller;

import com.alasgarov.simplerestapi.dto.CreatePostRequest;
import com.alasgarov.simplerestapi.dto.PostDto;
import com.alasgarov.simplerestapi.dto.UpdatePostRequest;
import com.alasgarov.simplerestapi.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PatchMapping("/{id}")
    void updatePostPartially(@PathVariable Long id, @RequestParam String title){
        postService.updatePostTitle(id, title);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePostById(@PathVariable Long id){
        postService.deletePost(id);
    }

    @PutMapping("/{id}/updatePost")
    void updatePost(@PathVariable Long id, @RequestBody UpdatePostRequest request){
        postService.updatePost(id, request);
    }


}
