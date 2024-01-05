package cotato.hackathon.domain.block;

import cotato.hackathon.domain.block.dto.request.BlockSaveRequestDto;
import cotato.hackathon.domain.block.dto.request.BlockUpdateRequestDto;
import cotato.hackathon.domain.block.dto.response.BlockListResponseDto;
import cotato.hackathon.domain.block.dto.response.BlockResponseDto;
import cotato.hackathon.domain.block.enums.SortCategoryType;
import cotato.hackathon.domain.block.service.BlockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/blocks")
@Tag(name = "Block")
public class BlockController {

    private final BlockService blockService;

    @Operation(summary = "블록 조회")
    @GetMapping
    public BlockListResponseDto getBlocks(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "category", required = false) SortCategoryType category,
            @RequestParam(value = "user_id", required = false) Long userId) {
        log.info("키워드로 장소 조회");
        return blockService.getBlockList(keyword, category, userId);
    }

    @Operation(summary = "블록 작성")
    @PostMapping("blocks/write") // 작성
    public Long writeBlock(@RequestBody BlockSaveRequestDto requestDto) {
        return blockService.writeBlock(requestDto);
    }

    @Operation(summary = "블록 수정")
    @PutMapping("blocks/{block_id}/rewrite") // 수정
    public Long rewriteBlock(@PathVariable Long block_id, @RequestBody BlockUpdateRequestDto requestDto) {
        return blockService.rewriteBlock(block_id, requestDto);
    }

    @Operation(summary = "블록 삭제")
    @DeleteMapping("blocks/{block_id}") // 삭제
    public Long deleteBlock(@PathVariable Long block_id) {
        blockService.deleteBlock(block_id);
        return block_id;
    }
    @Operation(summary = "글 목록 보기")
    @GetMapping("blocks/all") // 글 목록 보기
    public List<BlockListResponseDto> findAll() {
        return blockService.findAllDesc();
    }

    @Operation(summary = "글 하나 보기")
    @GetMapping("blocks/{block_id}") // 글 하나 보기
    public BlockResponseDto findBlock(@PathVariable Long block_id) {
        return blockService.findById(block_id);
    }
}
