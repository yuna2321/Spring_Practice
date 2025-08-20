package miniproject.demo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import miniproject.demo.DTO.*;
import miniproject.demo.entity.Board;
import miniproject.demo.entity.Likes;
import miniproject.demo.entity.User;
import miniproject.demo.repository.BoardRepository;
import miniproject.demo.repository.LikeRepository;
import miniproject.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final LikeRepository likeRepository;


    //좋아요 누르기
    //DTO -> Entity 전환
    @Transactional
    public LikeResponseDTO pushLike(LikeRequestDTO likeRequestDTO) {

        //좋아요를 누른 작성자를 저장하기 위해 필요
        User user = userRepository.getReferenceById(likeRequestDTO.getUserId());
        //좋아요를 누른 게시글을 저장하기 위해 필요
        Board board = boardRepository.getReferenceById(likeRequestDTO.getBoardId());


        Likes likes = Likes.builder()
                .user(user)
                .board(board)
                .isLike(likeRequestDTO.isLike())
                .build();

        likeRepository.save(likes);

        return LikeResponseDTO.from(likes);
    }

    //좋아요 취소하기
    //DTO -> Entity 전환
    @Transactional
    public LikeResponseDTO deleteLike(LikeRequestDTO likeRequestDTO) {

        //좋아요를 누른 작성자를 저장하기 위해 필요
        User user = userRepository.getReferenceById(likeRequestDTO.getUserId());
        //좋아요를 누른 게시글을 저장하기 위해 필요
        Board board = boardRepository.getReferenceById(likeRequestDTO.getBoardId());


        Likes likes = Likes.builder()
                .user(user)
                .board(board)
                .isLike(likeRequestDTO.isLike())
                .build();

        likeRepository.save(likes);

        return LikeResponseDTO.from(likes);
    }

}
