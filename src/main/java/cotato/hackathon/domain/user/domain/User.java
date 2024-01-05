package cotato.hackathon.domain.user.domain;


import cotato.hackathon.domain.user.dto.request.JoinRequestDTO;
import cotato.hackathon.global.common.entity.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Size(max = 30)
    private String name;

    @Nullable
    @Size(max = 30)
    private String nickname;

    @NotNull
    @Size(max = 20)
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(max = 128)
    private String password;

    @Nullable
    @Size(max = 120)
    private String imageURL;


    // 생성자
    @Builder
    private User(
            String name,
            String username,
            String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public static User of(JoinRequestDTO joinRequestDTO, String encodedPassword) {
        return User.builder()
                .name(joinRequestDTO.getUserVo().getName())
                .username(joinRequestDTO.getUserVo().getUsername())
                .password(encodedPassword)
                .build();
    }
}
