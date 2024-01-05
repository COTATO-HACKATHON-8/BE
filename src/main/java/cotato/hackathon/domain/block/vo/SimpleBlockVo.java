package cotato.hackathon.domain.block.vo;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SimpleBlockVo {

    private Long blockId;
    private String blockImageURL;
    private Category category;
    private String title;
    private String contents;
    private String username;
    private String userImageURL;

    @Builder
    private SimpleBlockVo(
            Long blockId,
            String blockImageURL,
            Category category,
            String title,
            String contents,
            String username,
            String userImageURL) {
        this.blockId = blockId;
        this.blockImageURL = blockImageURL;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.userImageURL = userImageURL;
    }

    public static SimpleBlockVo from(Block block) {
        return SimpleBlockVo.builder()
                .blockId(block.getId())
                .blockImageURL(block.getImageURL())
                .category(block.getCategory())
                .title(block.getTitle())
                .contents(block.getContents())
                .username(block.getUser().getUsername())
                .userImageURL(block.getUser().getImageURL())
                .build();
    }
}
