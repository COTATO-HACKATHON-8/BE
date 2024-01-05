package cotato.hackathon.domain.block.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import cotato.hackathon.domain.block.dto.request.BlockSaveRequestDto;
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
    private int likes;

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

    public static Block of(User user, BlockSaveRequestDto blockSaveRequestDto) {
        return Block.builder()
                .user(user)
                .category(blockSaveRequestDto.getCategory())
                .title(blockSaveRequestDto.getTitle())
                .contents(blockSaveRequestDto.getContents())
                .imageURL(blockSaveRequestDto.getImageURL())
                .build();
    }
    public void update(String title, String contents, User user, Category category, String imageURL, int likes) {
        this.title = title;
        this.contents = contents;
        this.user = user;
        this.category = category;
        this.imageURL = imageURL;
        this.likes = likes;
    }
}
