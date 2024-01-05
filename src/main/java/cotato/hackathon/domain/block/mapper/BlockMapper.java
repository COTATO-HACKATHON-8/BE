package cotato.hackathon.domain.block.mapper;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.dto.response.BlockListResponseDTO;
import cotato.hackathon.domain.block.vo.SimpleBlockVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlockMapper {

    public BlockListResponseDTO toBlockListDTO(List<Block> blocks) {
        List<SimpleBlockVo> mapBlocks =
                blocks.stream()
                        .map(SimpleBlockVo::from)
                        .toList();
        return BlockListResponseDTO.from(mapBlocks);
    }
}
