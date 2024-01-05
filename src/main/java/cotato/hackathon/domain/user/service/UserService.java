package cotato.hackathon.domain.user.service;


import cotato.hackathon.domain.user.domain.User;
import cotato.hackathon.domain.user.dto.request.JoinRequestDTO;
import cotato.hackathon.domain.user.helper.UserHelper;
import cotato.hackathon.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserHelper userHelper;

    public void joinUser(JoinRequestDTO joinRequestDTO) {
        final String encodedPassword =
                userHelper.encodePassword(joinRequestDTO.getUserVo().getPassword());
        final User user = User.of(joinRequestDTO, encodedPassword);
        userRepository.save(user);
    }
}
