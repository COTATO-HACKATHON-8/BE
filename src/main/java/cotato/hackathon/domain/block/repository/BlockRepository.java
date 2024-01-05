package cotato.hackathon.domain.block.repository;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.dto.response.BlockListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface BlockRepository extends JpaRepository<Block, Long>, BlockCustomRepository {

    List<BlockListResponseDto> findAllDesc();
}




