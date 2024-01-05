package cotato.hackathon.domain.user.dto.request;

import lombok.Getter;

@Getter
public class LoginDto {
    private String username;
    private String password;
}
