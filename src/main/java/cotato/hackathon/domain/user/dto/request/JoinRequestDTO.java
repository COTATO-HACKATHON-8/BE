package cotato.hackathon.domain.user.dto.request;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import cotato.hackathon.domain.user.vo.UserVo;
import lombok.Getter;

@Getter
public class JoinRequestDTO {

    @JsonUnwrapped private UserVo userVo;
}
