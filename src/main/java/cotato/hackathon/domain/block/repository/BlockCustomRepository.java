package cotato.hackathon.domain.block.repository;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.domain.Category;

import java.util.List;

public interface BlockCustomRepository {
    List<Block> findByFilter(String keyword, Category category, Long placeId);
}
