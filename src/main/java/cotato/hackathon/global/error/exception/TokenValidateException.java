package cotato.hackathon.global.error.exception;


import cotato.hackathon.global.error.BaseErrorException;
import cotato.hackathon.global.error.GlobalErrorCode;

public class TokenValidateException extends BaseErrorException {

    public static final BaseErrorException EXCEPTION = new TokenValidateException();

    private TokenValidateException() {
        super(GlobalErrorCode.INVALID_AUTH_TOKEN);
    }
}
