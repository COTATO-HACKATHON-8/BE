package cotato.hackathon.domain.user.exception;

import cotato.hackathon.global.error.BaseErrorException;

public class UserNotFound extends BaseErrorException {
    public static final UserNotFound EXCEPTION = new UserNotFound();

    public UserNotFound() {
        super(UserErrorcode.USER_NOT_FOUND);
    }
}
