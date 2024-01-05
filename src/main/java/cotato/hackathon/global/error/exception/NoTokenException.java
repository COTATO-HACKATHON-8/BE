package cotato.hackathon.global.error.exception;

import cotato.hackathon.global.error.BaseErrorException;
import cotato.hackathon.global.error.GlobalErrorCode;

public class NoTokenException extends BaseErrorException {

    public static final BaseErrorException EXCEPTION = new NoTokenException();

    private NoTokenException() {
        super(GlobalErrorCode.NO_TOKEN);
    }
}
