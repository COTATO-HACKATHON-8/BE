package cotato.hackathon.domain.block.exception;

import cotato.hackathon.global.common.dto.ErrorReason;
import cotato.hackathon.global.error.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum BlockErrorcode implements BaseErrorCode {
    BLOCK_NOT_FOUND(NOT_FOUND, "BLOCK_404_1", "해당 블록을 찾을 수 없습니다.");

    private HttpStatus status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.of(status.value(), code, reason);
    }
}
