package cotato.hackathon.domain.block.service;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.dto.request.BlockSaveRequestDto;
import cotato.hackathon.domain.block.dto.request.BlockUpdateRequestDto;
import cotato.hackathon.domain.block.dto.response.BlockListResponseDto;
import cotato.hackathon.domain.block.dto.response.BlockResponseDto;
import cotato.hackathon.domain.block.enums.SortCategoryType;
import cotato.hackathon.domain.block.helper.BlockHelper;
import cotato.hackathon.domain.block.mapper.BlockMapper;
import cotato.hackathon.domain.block.repository.BlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlockService {

    private final BlockRepository blockRepository;
    private final BlockMapper blockMapper;
    private final BlockHelper blockHelper;

    @Transactional(readOnly = true)
    public BlockListResponseDto getBlockList(String keyword, SortCategoryType category, Long placeId) {
        List<Block> blocks = blockHelper.getBlockList(keyword, category, placeId);
        return blockMapper.toBlockListDTO(blocks);
    }

    @Transactional // 엔티티를 데이터베이스에 저장하고, 저장된 엔티티의 ID를 반환
    public Long writeBlock(BlockSaveRequestDto requestDto) {
        return blockRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional // 특정 id의 엔티티 조희
    public Long rewriteBlock(Long id, BlockUpdateRequestDto requestDto) {
        Block block = blockRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 블록이 없습니다. id=" + id));
        block.update(requestDto.getTitle(), requestDto.getContents(), requestDto.getUser(), requestDto.getCategory(), requestDto.getImageURL(), requestDto.getLikes());
        return id;
    }

    @Transactional // 엔티티 삭제
    public void deleteBlock (Long id) {
        Block block = blockRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 블록이 없습니다. id=" + id));
        blockRepository.delete(block);
    }

    @Transactional(readOnly = true) // 특정 id의 엔티티 조회(보기전용)
    public BlockResponseDto findById (Long id) {
        Block entity = blockRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 블록이 없습니다. id=" + id));
        return new BlockResponseDto(entity);
    }

    @Transactional(readOnly = true) // 전체 조희
    public List<BlockListResponseDto> findAllDesc() {
        return blockRepository.findAllDesc().stream()
                .map(BlockListResponseDto::new)
                .collect(Collectors.toList());
    }
}
