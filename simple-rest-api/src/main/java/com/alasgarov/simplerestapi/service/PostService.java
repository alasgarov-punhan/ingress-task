package com.alasgarov.simplerestapi.service;

import com.alasgarov.simplerestapi.dto.CreatePostRequest;
import com.alasgarov.simplerestapi.dto.PostDto;
import com.alasgarov.simplerestapi.dto.converter.PostDtoConverter;
import com.alasgarov.simplerestapi.model.Post;
import com.alasgarov.simplerestapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final PostDtoConverter postDtoConverter;

    public List<PostDto> getAllPost(){
        log.info("ActionLog.requestTransactionReport.start.");
        return postDtoConverter.converter(postRepository.findAll());
    }

    public PostDto createPost(CreatePostRequest request){
        Post post = Post.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .createdDate(LocalDateTime.now())
                .build();
        return postDtoConverter.converter(postRepository.save(post));
    }

    public void deletePost(Long id){
        Post post = findBydId(id);
        postRepository.delete(post);
    }

    private Post findBydId(Long id){
        return postRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Post not found")
        );
    }
}
