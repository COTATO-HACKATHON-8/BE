package cotato.hackathon.domain.block;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikesController {

    private final LikesService likesService;

    @GetMapping // 좋아요 누르기
    public ResponseResult<?> insert(@RequestBody @Valid LikesRequestDTO likesRequestDTO) {
        likesService.insert(likesRequestDTO);
        return success(null);
    }

    @DeleteMapping // 좋아요 취소
    public ResponseResult<?> delete(@RequestBody @Valid LikesRequestDTO likesRequestDTO) {
        likesService.delete(likesRequestDTO);
        return success(null);
    }

}