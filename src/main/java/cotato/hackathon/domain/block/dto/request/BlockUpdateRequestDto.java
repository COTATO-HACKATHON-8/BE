package cotato.hackathon.domain.block.dto.request;

import cotato.hackathon.domain.block.domain.Category;
import cotato.hackathon.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlockUpdateRequestDto {
    private String title;
    private String contents;
    private User user;
    private Category category;
    private String imageURL;
    private int likes;
    @Builder
    public BlockUpdateRequestDto(String title, String contents, User user, Category category, String imageURL, int likes) {
        this.title = title;
        this.contents = contents;
        this.user = user;
        this.category = category;
        this.imageURL = imageURL;
        this.likes = likes;
    }
}
