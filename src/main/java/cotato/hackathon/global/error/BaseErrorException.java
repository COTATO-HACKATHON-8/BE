package cotato.hackathon.global.error;


import lombok.AllArgsConstructor;
import lombok.Getter;
import cotato.hackathon.global.common.dto.ErrorReason;

@Getter
@AllArgsConstructor
public class BaseErrorException extends RuntimeException {
    private BaseErrorCode errorCode;

    public ErrorReason getErrorReason() {
        return this.errorCode.getErrorReason();
    }
}
