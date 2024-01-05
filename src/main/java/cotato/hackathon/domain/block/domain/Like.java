package cotato.hackathon.domain.block.domain;

import cotato.hackathon.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;  // 이게 맞는지 모르겠음..

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "block_id")
    private Block block;

    @Builder
    private Like(User user, Block Block) {
        this.user = user;
        this.block = block;
    }

    public static Like of(User user, Block Block) {
        return Like.builder()
                .user(user)
                .Block(Block)
                .build();
    }
}