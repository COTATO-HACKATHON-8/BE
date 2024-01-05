package cotato.hackathon.domain.block.dto.response;

import cotato.hackathon.domain.block.domain.Block;
import lombok.Getter;

@Getter
public class BlockResponseDto {

    private Long id;
    private String title;
    private String content;
    private String user;


//    public BlockResponseDto(Block entity) {
//        this.id = entity.getId();
//        this.title = entity.getTitle();
//        this.content = entity.getContent();
//        this.user = entity.getUser();
//        this.likes = entity.getLikes();
//    }
}