//package cotato.hackathon.domain.block.domain;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import javax.persistence.Id;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Column;
//import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import static javax.persistence.FetchType.LAZY;
//
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Entity
//@Table(name = "likes")
//public class Likes {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "like_id")
//    private Long id;  // 이게 맞는지 모르겠음..
//
//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "block_id")
//    private Block block;
//
//}