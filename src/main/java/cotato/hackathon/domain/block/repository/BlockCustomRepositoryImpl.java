package cotato.hackathon.domain.block.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.domain.Category;
import cotato.hackathon.domain.block.domain.QBlock;
import cotato.hackathon.domain.user.domain.QUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlockCustomRepositoryImpl implements BlockCustomRepository {

    private final JPAQueryFactory queryFactory;

    QUser qUser = QUser.user;
    QBlock qBlock = QBlock.block;

    @Override
    public List<Block> findByFilter(String keyword, Category category, Long placeId) {
        return queryFactory.selectFrom(qBlock)
                .leftJoin(qBlock.user, qUser).fetchJoin()        // Fetch join for Place
                .where(containsKeyword(keyword))
                .where(eqCategory(category))
                .where(eqPlaceId(placeId))
                .fetch();
    }

    private BooleanExpression containsKeyword(String keyword) {
        return keyword == null ? null : qBlock.title.containsIgnoreCase(keyword)
                .or(qBlock.contents.containsIgnoreCase(keyword));
    }

    private BooleanExpression eqCategory(Category category) {
        return category == null ? null : qBlock.category.eq(category);
    }

    private BooleanExpression eqPlaceId(Long userId) {
        return userId == null ? null : qBlock.user.id.eq(userId);
    }
}
