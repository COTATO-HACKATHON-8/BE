package cotato.hackathon.domain.block.service;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.dto.request.BlockSaveRequestDto;
import cotato.hackathon.domain.block.dto.request.BlockUpdateRequestDto;
import cotato.hackathon.domain.block.dto.response.BlockListResponseDto;
import cotato.hackathon.domain.block.dto.response.BlockResponseDTO;
import cotato.hackathon.domain.block.enums.SortCategoryType;
import cotato.hackathon.domain.block.helper.BlockHelper;
import cotato.hackathon.domain.block.mapper.BlockMapper;
import cotato.hackathon.domain.block.repository.BlockRepository;
import cotato.hackathon.domain.block.repository.LikeRepository;
import cotato.hackathon.domain.user.domain.User;
import cotato.hackathon.global.config.user.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlockService {

    private final BlockRepository blockRepository;
    private final BlockMapper blockMapper;
    private final BlockHelper blockHelper;
    private final LikeRepository likeRepository;

    @Transactional(readOnly = true)
    public BlockListResponseDto getBlockList(String keyword, SortCategoryType category, Long placeId) {
        List<Block> blocks = blockHelper.getBlockList(keyword, category, placeId);
        return blockMapper.toBlockListDTO(blocks);
    }

    @Transactional // 엔티티를 데이터베이스에 저장하고, 저장된 엔티티의 ID를 반환
    public Long writeBlock(UserDetails userDetails, BlockSaveRequestDto requestDto) {
        User user = userDetails.getUser();
        Block block = Block.of(user, requestDto);

        return blockRepository.save(block).getId();
    }

    @Transactional // 특정 id의 엔티티 조희
    public Long rewriteBlock(UserDetails userDetails, Long id, BlockUpdateRequestDto requestDto) {
        User user = userDetails.getUser();
        Block block = blockRepository.findByUserAndId(user, id)
                .orElseThrow(() -> new IllegalArgumentException("해당 블록이 없습니다. id=" + id));
        block.update(requestDto.getTitle(), requestDto.getContents(), requestDto.getCategory(), requestDto.getImageURL());
        return id;
    }

    @Transactional // 엔티티 삭제
    public void deleteBlock (UserDetails userDetails, Long id) {
        User user = userDetails.getUser();
        Block block = blockRepository.findByUserAndId(user, id)
                .orElseThrow(() -> new IllegalArgumentException("해당 블록이 없습니다. id=" + id));
        blockRepository.delete(block);
    }

    @Transactional(readOnly = true) // 특정 id의 엔티티 조회(보기전용)
    public BlockResponseDTO findById (Long id) {
        Block block = blockRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 블록이 없습니다. id=" + id));
        Long likeCount = likeRepository.countByBlock(block);
        return BlockResponseDTO.of(block, likeCount);
    }
}
