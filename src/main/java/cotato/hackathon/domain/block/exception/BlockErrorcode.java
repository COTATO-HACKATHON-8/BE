package cotato.hackathon.domain.block.exception;

import cotato.hackathon.global.common.dto.ErrorReason;
import cotato.hackathon.global.error.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum BlockErrorcode implements BaseErrorCode {
    DUPLICATE_USERNAME(CONFLICT, "USER_409_1", "해당 아이디의 유저가 존재합니다."),
    DUPLICATE_NICKNAME(CONFLICT, "USER_409_2", "해당 닉네임의 유저가 존재합니다."),
    USER_NOT_FOUND(NOT_FOUND, "USER_404_1", "해당 유저를 찾을 수 없습니다.");

    private HttpStatus status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.of(status.value(), code, reason);
    }
}
