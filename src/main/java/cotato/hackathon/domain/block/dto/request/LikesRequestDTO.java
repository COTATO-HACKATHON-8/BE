package cotato.hackathon.domain.block.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikesRequestDTO {
    private Long user_id; // 좋아요를 누른 유저
    private Long block_id;

    public LikesRequestDTO(Long user_id, Long block_id) {
        this.user_id = user_id;
        this.block_id = block_id;
    }
}