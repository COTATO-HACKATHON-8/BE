package cotato.hackathon.domain.block.dto;

import cotato.hackathon.domain.block.domain.Blocks;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlocksSaveRequestDto {
    private User user; // 작성자
    private Category category; // 카테고리
    private String title; // 제목
    private String contents; // 글
    private String imageURL; // 이미지
    private Int likes; // 좋아요 수


    @Builder
    public PostsSaveRequestDto(User user, Category category, String title, String contents, String imageURL, Int likes) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.imageURL = imageURL;
        this.likes = likes;
    }

    public Blocks toEntity() {
        return Blocks.builder()
                .user(user)
                .category(category)
                .title(title)
                .contents(contents)
                .imageURL(imageURL)
                .likes(likes)
                .build();
    }

}