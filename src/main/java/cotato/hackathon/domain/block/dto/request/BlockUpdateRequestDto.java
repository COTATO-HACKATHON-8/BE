package cotato.hackathon.domain.block.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlocksUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public BlocksUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}