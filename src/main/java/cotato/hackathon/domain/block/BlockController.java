package cotato.hackathon.domain.block;

import cotato.hackathon.domain.block.dto.response.BlockListResponseDTO;
import cotato.hackathon.domain.block.enums.SortCategoryType;
import cotato.hackathon.domain.block.service.BlockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/blocks")
@Tag(name = "Block")
public class BlockController {

    private final BlockService blockService;

    @Operation(summary = "블록 조회")
    @GetMapping
    public BlockListResponseDTO getBlocks(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "category", required = false) SortCategoryType category,
            @RequestParam(value = "user_id", required = false) Long userId) {
        log.info("키워드로 장소 조회");
        return blockService.getBlockList(keyword, category, userId);
    }
}
