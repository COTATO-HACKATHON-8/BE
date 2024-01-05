package cotato.hackathon.domain.block.exception;

import cotato.hackathon.domain.user.exception.UserErrorcode;
import cotato.hackathon.global.error.BaseErrorException;

public class BlockNotFound extends BaseErrorException {
    public static final BlockNotFound EXCEPTION = new BlockNotFound();

    public BlockNotFound() {
        super(UserErrorcode.USER_NOT_FOUND);
    }
}
