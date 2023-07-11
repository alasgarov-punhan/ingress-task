package com.alasgarov.simplerestapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String body;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;
    private LocalDate updateDate;

    public Post() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(body, post.body) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body);
    }
}
