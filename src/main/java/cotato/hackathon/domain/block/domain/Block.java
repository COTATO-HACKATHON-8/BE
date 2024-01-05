package cotato.hackathon.domain.block.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import cotato.hackathon.domain.user.domain.User;
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
public class Block extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // Cascade
    @JsonBackReference
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    @Size(max = 20)
    @Column(unique = true)
    private String title;

    @NotNull
    @Column(unique = true)
    private String contents;

    @NotNull
    @Size(max = 128)
    private String imageURL;

    // 생성자
    @Builder
    private Block(
            User user,
            Category category,
            String title,
            String contents,
            String imageURL) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.imageURL = imageURL;
    }

    public static Block from() {
        return Block.builder()
                .build();
    }
}
