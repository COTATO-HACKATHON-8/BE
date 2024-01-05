package cotato.hackathon.domain.user.domain;


import cotato.hackathon.global.common.entity.BaseEntity;
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
    @Size(max = 20)
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(max = 128)
    private String password;

    @NotNull
    @Size(max = 30)
    private String nickname;

    @NotNull
    @Size(max = 120)
    private String imageURL;


    // 생성자
    @Builder
    private User(
            String username,
            String password,
            String nickname,
            String imageURL) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.imageURL = imageURL;

    }

    public static User of() {
        return User.builder()
                .build();
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }
}
