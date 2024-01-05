package cotato.hackathon.domain.block.dto.response;

import cotato.hackathon.domain.block.vo.SimpleBlockVo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class BlockListResponseDTO {

    List<SimpleBlockVo> blocks;

    @Builder
    private BlockListResponseDTO(List<SimpleBlockVo> blocks) {
        this.blocks = blocks;
    }

    public static BlockListResponseDTO from(List<SimpleBlockVo> blocks) {
        return BlockListResponseDTO.builder()
                .blocks(blocks)
                .build();
    }
}
