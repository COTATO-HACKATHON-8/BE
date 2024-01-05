package cotato.hackathon.domain.user.exception;

import cotato.hackathon.global.error.BaseErrorException;

public class DuplicateNickname extends BaseErrorException {
    public static final DuplicateNickname EXCEPTION = new DuplicateNickname();

    public DuplicateNickname() {
        super(UserErrorcode.DUPLICATE_NICKNAME);
    }
}
