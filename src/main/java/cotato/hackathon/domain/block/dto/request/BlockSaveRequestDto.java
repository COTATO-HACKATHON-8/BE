package cotato.hackathon.domain.block.dto.request;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.domain.Category;
import cotato.hackathon.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlockSaveRequestDto {
    private User user; // 작성자
    private Category category; // 카테고리
    private String title; // 제목
    private String contents; // 글
    private String imageURL; // 이미지
    private int likes; // 좋아요 수

    public Block toEntity() {
        return Block.builder()
                .title(title)
                .contents(contents)
                .user(user)
                .imageURL(imageURL)
                .category(category)
                .build();
    }
}