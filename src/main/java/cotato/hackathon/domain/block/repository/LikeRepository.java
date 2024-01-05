package cotato.hackathon.domain.block.repository;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.domain.Like;
import cotato.hackathon.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    Optional<Like> findByUserAndBlock(User user, Block block);
    Long countByBlock(Block block);
    Long countByUser(User user);}




