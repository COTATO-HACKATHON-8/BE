package cotato.hackathon.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import cotato.hackathon.global.common.dto.ErrorReason;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements BaseErrorCode {

    HTTP_MESSAGE_NOT_READABLE(BAD_REQUEST, "GLOBAL_400_1", "잘못된 형식의 값을 입력했습니다."),
    _INTERNAL_SERVER_ERROR(INTERNAL_SERVER_ERROR, "GLOBAL_500_1", "서버 오류. 관리자에게 문의 부탁드립니다."),

    NO_TOKEN(UNAUTHORIZED, "AUTH_401_1", "토큰이 존재하지 않습니다"),
    INVALID_AUTH_TOKEN(UNAUTHORIZED, "AUTH_401_2", "액세스 토큰이 유효하지 않습니다");

    private HttpStatus status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.of(status.value(), code, reason);
    }
}
