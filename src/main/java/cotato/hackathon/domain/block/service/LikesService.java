package cotato.hackathon.domain.block.service;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final LikesRepository likesRepository;
    private final UserRepository userRepository;
    private final BlocksRepository blocksRepository;

    @Transactional
    public void insert(LikesRequestDTO likesRequestDTO) throws Exception {

        User user = userRepository.findById(userRequestDTO.getUserId())
                .orElseThrow(() -> new NotFoundException("해당 유저가 없습니다. id=" + likesRequestDTO.getUserId()));

        Block block = blocksRepository.findById(blocksRequestDTO.getBlockId())
                .orElseThrow(() -> new NotFoundException("해당 블록이 없습니다. id=" + likesRequestDTO.getBlockId()));

        // 이미 좋아요 되어있으면 에러 반환
        if (likesRepository.findByUserAndBlock(user, board).isPresent()) {
            throw new Exception();
        }

        Likes likes = Likes.builder()
                .block(block)
                .user(user)
                .build();

        likesRepository.save(like);
        blocksRepository.addLikeCount(block);
    }

    @Transactional
    public void insert(LikesRequestDTO likesRequestDTO) throws Exception {

        User user = userRepository.findById(userRequestDTO.getMemberId())
                .orElseThrow(() -> new NotFoundException("해당 유저가 없습니다. id=" + likesRequestDTO.getUserId()));

        Block block = blocksRepository.findById(blocksRequestDTO.getBlockId())
                .orElseThrow(() -> new NotFoundException("해당 블록이 없습니다. id=" + likesRequestDTO.getBlockId()));

        // 이미 좋아요 되어있으면 에러 반환
        if (likesRepository.findByUserAndBlock(user, board).isPresent()) {
            //TODO 409에러로 변경
            throw new Exception();
        }
        likesRepository.save(like);
        blockRepository.subLikeCount(block);
    }
}