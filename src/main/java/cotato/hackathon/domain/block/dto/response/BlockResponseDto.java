package cotato.hackathon.domain.block.dto.response;

import cotato.hackathon.domain.block.domain.Blocks;
import lombok.Getter;

@Getter
public class BlocksResponseDto {

    private Long id;
    private String title;
    private String content;
    private String user;

    public BlocksResponseDto(Blocks entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.user = entity.getUser();
        this.likes = entity.getLikes();
    }
}