package cotato.hackathon.domain.block.dto.response;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.domain.Category;
import cotato.hackathon.domain.user.domain.User;
import lombok.Builder;

public class BlockResponseDTO {
    private Long id;
    private User user;
    private Category category;
    private String imageUrl;
    private String title;;
    private String contents;
    private int likes;

    @Builder
    private BlockResponseDTO(Long id, User user, Category category, String imageUrl, String title, String contents, Integer likes) {
        this.id = id;
        this.category = category;
        this.imageUrl = imageUrl;
        this.user = user;
        this.title = title;
        this.contents = contents;
        this.likes = likes;
    }

    public static BlockResponseDTO of(Block block, int likeCount) {
        return BlockResponseDTO.builder()
                .id(block.getId())
                .category(block.getCategory())
                .imageUrl(block.getImageURL())
                .user(block.getUser())
                .title(block.getTitle())
                .contents(block.getContents())
                .likes(likeCount)
                .build();
    }
}
