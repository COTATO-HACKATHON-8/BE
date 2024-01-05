package cotato.hackathon.domain.user.exception;

import cotato.hackathon.global.error.BaseErrorException;

public class DuplicateUsername extends BaseErrorException {
    public static final DuplicateUsername EXCEPTION = new DuplicateUsername();

    public DuplicateUsername() {
        super(UserErrorcode.DUPLICATE_USERNAME);
    }
}
