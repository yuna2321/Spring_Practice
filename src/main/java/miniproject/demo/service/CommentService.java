package miniproject.demo.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import miniproject.demo.DTO.BoardCreateRequestDTO;
import miniproject.demo.DTO.BoardResponseDTO;
import miniproject.demo.DTO.CommentRequestDTO;
import miniproject.demo.DTO.CommentResponseDTO;
import miniproject.demo.entity.Board;
import miniproject.demo.entity.Comment;
import miniproject.demo.entity.User;
import miniproject.demo.repository.BoardRepository;
import miniproject.demo.repository.CommentRepository;
import miniproject.demo.repository.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    //댓글 작성
    //DTO->Entity 변환 후 DB에 저장
    @Transactional
    public CommentResponseDTO createComment(CommentRequestDTO commentRequestDTO) {

        //댓글을 작성한 작성자를 저장하기 위해 필요
        User user = userRepository.getReferenceById(commentRequestDTO.getUserId());
        //댓글을 작성한 게시글을 저장하기 위해 필요
        Board board = boardRepository.getReferenceById(commentRequestDTO.getBoardId());

        Comment comment = Comment.builder()
                .user(user)
                .board(board)
                .content(commentRequestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .build();

        //save 함수
        commentRepository.save(comment);

        //다시 DTO로 전환 후 리턴
        return CommentResponseDTO.from(comment);
    }

    //해당 게시글 댓글 전체 조회
    //Entity->DTO 변환
    @Transactional
    public List<CommentResponseDTO> getCommentsByBoard(Long boardId) {
        List<Comment> comment_list = commentRepository.findByBoard_BoardIdOrderByCreatedAtAsc(boardId);
        List<CommentResponseDTO> commentResponseDTOList = new ArrayList<>();

        for(Comment comment : comment_list) {
            CommentResponseDTO commentResponseDTO = CommentResponseDTO.from(comment);
            commentResponseDTOList.add(commentResponseDTO);
        }

        return commentResponseDTOList;
    }

    //댓글 삭제
    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment_delete;
        comment_delete = commentRepository.findById(commentId).get();

        commentRepository.delete(comment_delete);
    }


}
