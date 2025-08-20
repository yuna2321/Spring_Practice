package miniproject.demo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import miniproject.demo.DTO.BoardCreateRequestDTO;
import miniproject.demo.DTO.BoardResponseDTO;
import miniproject.demo.DTO.BoardUpdateRequestDTO;
import miniproject.demo.DTO.UserRequestDTO;
import miniproject.demo.entity.Board;
import miniproject.demo.entity.User;
import miniproject.demo.repository.BoardRepository;
import miniproject.demo.repository.CommentRepository;
import miniproject.demo.repository.LikeRepository;
import miniproject.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;

    private Long commentCount;
    private Long likeCount;


    //게시글 작성
    //DTO->Entity 변환 후 DB에 저장
    @Transactional
    public BoardResponseDTO createBoard(BoardCreateRequestDTO boardRequestDTO) {
        //게시글을 작성한 작성자를 저장하기 위해 필요
        User user = userRepository.getReferenceById(boardRequestDTO.getUserId());
        Board board = Board.builder()
                .user(user)
                .title(boardRequestDTO.getTitle())
                .content(boardRequestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        //save 함수
        boardRepository.save(board);

        //처음 생성시 0개
        commentCount = 0L;

        likeCount = 0L;

        //다시 DTO로 전환 후 리턴
        return BoardResponseDTO.from(board, commentCount, likeCount);
    }

    //게시글 리스트
    //조회 Entity->DTO
    @Transactional
    public List<BoardResponseDTO> boardList() {
        List<Board> board_list = boardRepository.findAll();
        List<BoardResponseDTO> boardResponseDTOList = new ArrayList<>();


        for(Board board : board_list) {
            commentCount = commentRepository.countByBoard_BoardId(board.getBoardId());
            likeCount = likeRepository.countByBoard_BoardId(board.getBoardId());
            BoardResponseDTO boardResponseDTO = BoardResponseDTO.from(board, commentCount, likeCount);
            boardResponseDTOList.add(boardResponseDTO);
        }

        return boardResponseDTOList;
    }


    //특정 게시글 확인
    //조회, Entity -> DTO
    @Transactional
    public BoardResponseDTO boardView(Long boardId) {
        Board board;
        BoardResponseDTO boardResponseDTO;
        board = boardRepository.findById(boardId).get();

        commentCount = commentRepository.countByBoard_BoardId(boardId);

        boardResponseDTO = BoardResponseDTO.from(board, commentCount, likeCount);

        return boardResponseDTO;
    }


    //게시글 수정
    //DTO -> Entity
    @Transactional
    public void boardUpdate(Long boardId, BoardUpdateRequestDTO boardUpdateRequestDTO) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        if(boardUpdateRequestDTO.getTitle() != null) board.changeTitle(boardUpdateRequestDTO.getTitle());
        if(boardUpdateRequestDTO.getContent() != null) board.changeContent(boardUpdateRequestDTO.getContent());

        board.changeUpdatedAt(LocalDateTime.now());
    }

    //게시글 삭제
    @Transactional
    public void boardDelete(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow( ()-> new IllegalArgumentException("board not found"));

        boardRepository.delete(board);
    }






}
