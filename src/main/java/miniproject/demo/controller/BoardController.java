package miniproject.demo.controller;

import lombok.RequiredArgsConstructor;
import miniproject.demo.DTO.BoardCreateRequestDTO;
import miniproject.demo.DTO.BoardResponseDTO;
import miniproject.demo.DTO.BoardUpdateRequestDTO;
import miniproject.demo.service.BoardService;
import miniproject.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    BoardService boardService;

    //메인
    @GetMapping("/")
    public String mainForm() {
        return "index";
    }


    //게시글 생성
    @PostMapping("/api/boards")
    public BoardResponseDTO createBoard(@RequestBody BoardCreateRequestDTO boardCreateRequestDTO) {
        BoardResponseDTO boardResponseDTO;
        boardResponseDTO = boardService.createBoard(boardCreateRequestDTO);

        return boardResponseDTO;
    }

    //전체 조회
    @GetMapping("/api/boards")
    public List<BoardResponseDTO> showBoardList() {
        List<BoardResponseDTO> board_list;
        board_list = boardService.boardList();

        return board_list;
    }

    //상세 조회
    @GetMapping("/api/boards/{id}")
    public BoardResponseDTO boardView(@PathVariable("id") Long id, Model model) {
        return boardService.boardView(id);
    }

    //수정
    @PatchMapping("/api/boards/{id}")
    public void updateBoard(@PathVariable("id") Long boardId, @RequestBody BoardUpdateRequestDTO boardUpdateRequestDTO) {
        boardService.boardUpdate(boardId, boardUpdateRequestDTO);
    }

    //삭제
    @DeleteMapping("/api/boards/{id}")
    public void deleteBoard(@PathVariable("id") Long boardId) {
        boardService.boardDelete(boardId);
    }

}
