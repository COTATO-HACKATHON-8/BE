package cotato.hackathon.domain.block.repository;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlockRepository extends JpaRepository<Block, Long>, BlockCustomRepository {

    Optional<Block> findByUserAndId(User user, Long id);
    // List<BlockListResponseDto> findAllDesc();
}




