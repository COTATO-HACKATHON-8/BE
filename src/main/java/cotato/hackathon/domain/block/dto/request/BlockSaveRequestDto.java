package cotato.hackathon.domain.block.dto.request;

import cotato.hackathon.domain.block.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlockSaveRequestDto {
    private Category category; // 카테고리
    private String title; // 제목
    private String contents; // 글
    private String imageURL; // 이미지
    private int likes; // 좋아요 수

}