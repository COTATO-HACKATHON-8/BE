package cotato.hackathon.domain.user.helper;

import cotato.hackathon.domain.user.domain.User;
import cotato.hackathon.domain.user.exception.DuplicateUsername;
import cotato.hackathon.domain.user.exception.UserNotFound;
import cotato.hackathon.domain.user.repository.UserRepository;
import cotato.hackathon.global.config.user.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserHelper {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserDetailsService userDetailsService;

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean matchesPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
    
    public Authentication userAuthorizationInput(User user) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getId());
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails, "", userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return authentication;
    }

    public void findDuplicateUsername(String username) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw DuplicateUsername.EXCEPTION;
        }
    }

//    public User findForSignIn(SignInRequest signInRequest) {
//        User findUser =
//                userRepository
//                        .findByUsername(signInRequest.getUsername())
//                        .orElseThrow(
//                                () -> {
//                                    throw UserNotFound.EXCEPTION;
//                                });
//
//        if (!matchesPassword(signInRequest.getPassword(), findUser.getPassword())) {
//            throw MismatchPassword.EXCEPTION;
//        }
//
//        return findUser;
//    }

    public User findUser(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(
                        () -> {
                            throw UserNotFound.EXCEPTION;
                        });
    }
}
