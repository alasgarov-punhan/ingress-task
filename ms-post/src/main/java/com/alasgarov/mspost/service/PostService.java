package com.alasgarov.mspost.service;

import com.alasgarov.mspost.dto.CreatePostRequest;
import com.alasgarov.mspost.dto.PostDto;
import com.alasgarov.mspost.dto.converter.PostDtoConverter;
import com.alasgarov.mspost.model.Post;
import com.alasgarov.mspost.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final PostDtoConverter postDtoConverter;

    public List<PostDto> getAllPost(){
        log.info("ActionLog.requestTransactionReport.start.");
//        List<Post> postList = Arrays.asList(
//                new Post(1L, "", "", 2L, LocalDateTime.now(), LocalDateTime.now()),
//                new Post(1L, "", "", 2L, LocalDateTime.now(), LocalDateTime.now())
//        );
        return postDtoConverter.converter(postRepository.findAll());
//        return postDtoConverter.converter(postList);
    }

    public PostDto createPost(CreatePostRequest request){
        Post post = Post.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .userId(request.getUserId())
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
