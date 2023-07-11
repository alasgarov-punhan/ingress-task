package com.alasgarov.simplerestapi.dto.converter;

import com.alasgarov.simplerestapi.dto.PostDto;
import com.alasgarov.simplerestapi.model.Post;
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
                from.getTitle(),
                from.getBody(),
                from.getCreatedDate());
    }
}
