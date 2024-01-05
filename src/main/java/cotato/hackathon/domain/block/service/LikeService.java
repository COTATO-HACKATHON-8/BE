package cotato.hackathon.domain.block.service;

import cotato.hackathon.domain.block.domain.Block;
import cotato.hackathon.domain.block.domain.Like;
import cotato.hackathon.domain.block.repository.BlockRepository;
import cotato.hackathon.domain.block.repository.LikeRepository;
import cotato.hackathon.domain.user.domain.User;
import cotato.hackathon.domain.user.repository.UserRepository;
import cotato.hackathon.global.config.user.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final BlockRepository blocksRepository;

    @Transactional
    public void likeBlock(UserDetails userDetails, Long blockId) {
        User user = userDetails.getUser();
        Block block = blocksRepository.findById(blockId)
                .orElseThrow(() -> new NotFoundException("해당 블록이 없습니다."));

        // 이미 좋아요 되어있으면 에러 반환
//        if (likeRepository.findByUserAndBlock(user, block).isPresent()) {
//            throw new Exception("");
//        }

        Like like = Like.of(user, block);

        likeRepository.save(like);
    }

    @Transactional
    public void unlikeBlock(UserDetails userDetails, Long blockId) {
        User user = userDetails.getUser();
        Block block = blocksRepository.findById(blockId)
                .orElseThrow(() -> new NotFoundException("해당 블록이 없습니다"));

        Like like = likeRepository.findByUserAndBlock(user, block)
                .orElseThrow(() -> new NotFoundException("해당 좋아요가 없습니다"));
        // 이미 좋아요 되어있으면 에러 반환
//        if (likesRepository.findByUserAndBlock(user, board).isPresent()) {
//
//            throw new Exception();
//        }
        likeRepository.delete(like);
    }
}