package cotato.hackathon.domain.user;


import cotato.hackathon.domain.user.dto.request.JoinRequestDTO;
import cotato.hackathon.domain.user.dto.request.LoginDto;
import cotato.hackathon.domain.user.dto.response.TokenResponseDTO;
import cotato.hackathon.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
@Tag(name = "User")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입")
    @PostMapping("/join")
    public void joinUser(@RequestBody JoinRequestDTO joinRequestDTO) {
        userService.joinUser(joinRequestDTO);
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public TokenResponseDTO loginUser(@RequestBody LoginDto loginDto) {
        return userService.loginUser(loginDto);
    }

    @Operation(summary = "좋아요 수 확인")
    @GetMapping("/like/{user_id}")
    public Long countLikeByUser(
            @PathVariable(name = "user_id") Long userId) {
        return userService.countLikeByUser(userId);
    }


}
