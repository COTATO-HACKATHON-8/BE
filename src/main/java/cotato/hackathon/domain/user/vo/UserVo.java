package cotato.hackathon.domain.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class UserVo {
    @Schema()
    @NotEmpty(message = "아이디를 입력해주세요.")
    private String username;

    @Schema()
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;

    @Schema()
    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;
}
