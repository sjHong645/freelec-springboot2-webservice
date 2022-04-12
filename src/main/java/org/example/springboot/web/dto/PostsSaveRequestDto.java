package org.example.springboot.web.dto;

import org.example.springboot.domain.posts.*; // 이렇게 입력하니까 Test 무난히 통과

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto (String title, String content, String author){

        this.title = title;
        this.content = content;
        this.author = author;

    }

    public Posts toEntity() {

        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }


}
