package cotato.hackathon.domain.block.helper;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.domain.Category;
import cotato.hackathon.domain.block.enums.SortCategoryType;
import cotato.hackathon.domain.block.exception.BlockNotFound;
import cotato.hackathon.domain.block.repository.BlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BlockHelper {

    private final BlockRepository blockRepository;

    public List<Block> getBlockList(String keyword, SortCategoryType category, Long userId) {
        List<Block> blocks;

        blocks = blockRepository.findByFilter(keyword, toCategory(category), userId);

        if (blocks == null || blocks.isEmpty()) {
            throw BlockNotFound.EXCEPTION;
        }

        return blocks;
    }

    private Category toCategory(SortCategoryType sortType) {
        return switch (sortType) {
            case EXERCISE -> Category.EXERCISE;
            case MOVIE -> Category.MOVIE;
            case TRAVEL -> Category.TRAVEL;
            case MUSIC -> Category.MUSIC;
            case BOOK -> Category.BOOK;
            case PERFORMANCE -> Category.PERFORMANCE;
            case PHOTO -> Category.PHOTO;
            case INSTRUMENT -> Category.INSTRUMENT;
            case FOOD -> Category.FOOD;
            case DIY -> Category.DIY;
            case STUDY -> Category.STUDY;
            case GAME -> Category.GAME;
            case ART -> Category.ART;
            case COLLECTION -> Category.COLLECTION;
            case ETC -> Category.ETC;
            default -> null;
        };
    }
}
