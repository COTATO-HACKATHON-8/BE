package cotato.hackathon.domain.block.dto.response;

import cotato.hackathon.domain.block.vo.SimpleBlockVo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class BlockListResponseDto {

    List<SimpleBlockVo> blocks;

    @Builder
    private BlockListResponseDto(List<SimpleBlockVo> blocks) {
        this.blocks = blocks;
    }

    public static BlockListResponseDto from(List<SimpleBlockVo> blocks) {
        return BlockListResponseDto.builder()
                .blocks(blocks)
                .build();
    }
}
