package cotato.hackathon.domain.block.service;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.dto.response.BlockListResponseDTO;
import cotato.hackathon.domain.block.enums.SortCategoryType;
import cotato.hackathon.domain.block.helper.BlockHelper;
import cotato.hackathon.domain.block.mapper.BlockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlockService {

    private final BlockMapper blockMapper;
    private final BlockHelper blockHelper;

    @Transactional(readOnly = true)
    public BlockListResponseDTO getBlockList(String keyword, SortCategoryType category, Long placeId) {
        List<Block> blocks = blockHelper.getBlockList(keyword, category, placeId);
        return blockMapper.toBlockListDTO(blocks);
    }
}
