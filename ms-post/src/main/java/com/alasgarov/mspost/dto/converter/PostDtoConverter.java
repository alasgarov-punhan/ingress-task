package com.alasgarov.mspost.dto.converter;

import com.alasgarov.mspost.dto.PostDto;
import com.alasgarov.mspost.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostDtoConverter {

    public List<PostDto> converter(List<Post> from){
        return from.stream().map(this::converter).collect(Collectors.toList());
    }

    public PostDto converter(Post from){
        return new PostDto(
                from.getId(),
                from.getUserId(),
                from.getTitle(),
                from.getBody(),
                from.getCreatedDate());
    }
}
