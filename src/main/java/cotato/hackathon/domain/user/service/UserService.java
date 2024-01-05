package cotato.hackathon.domain.user.service;


import cotato.hackathon.domain.user.domain.User;
import cotato.hackathon.domain.user.dto.request.JoinRequestDTO;
import cotato.hackathon.domain.user.dto.request.LoginDto;
import cotato.hackathon.domain.user.dto.response.TokenResponseDTO;
import cotato.hackathon.domain.user.helper.UserHelper;
import cotato.hackathon.domain.user.repository.UserRepository;
import cotato.hackathon.global.config.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserHelper userHelper;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Transactional
    public TokenResponseDTO loginUser(LoginDto loginDto) {

        // repository 아이디랑 비밀번호 일치하는 유저 찾고
        User user = userRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 Email 입니다."));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("이메일 또는 번호가 맞지 않습니다.");
        }
        final String accessToken = tokenProvider.createAccessToken(user.getId());

        return TokenResponseDTO.from(accessToken);
    }

    public void joinUser(JoinRequestDTO joinRequestDTO) {
        final String encodedPassword =
                userHelper.encodePassword(joinRequestDTO.getUserVo().getPassword());
        final User user = User.of(joinRequestDTO, encodedPassword);
        userRepository.save(user);
    }
}
