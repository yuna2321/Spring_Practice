package miniproject.demo.controller;


import lombok.RequiredArgsConstructor;
import miniproject.demo.DTO.BoardCreateRequestDTO;
import miniproject.demo.DTO.BoardResponseDTO;
import miniproject.demo.DTO.CommentRequestDTO;
import miniproject.demo.DTO.CommentResponseDTO;
import miniproject.demo.entity.Comment;
import miniproject.demo.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 생성
    @PostMapping("/api/v1/comments")
    public CommentResponseDTO createComment(@RequestBody CommentRequestDTO commentRequestDTO) {
        CommentResponseDTO commentResponseDTO;
        commentResponseDTO = commentService.createComment(commentRequestDTO);

        return commentResponseDTO;
    }

    //댓글 조회
    @GetMapping("/api/v1/board/{boardId}/comments")
    public List<CommentResponseDTO> viewComment(@PathVariable("boardId") Long boardId) {
        List<CommentResponseDTO> comment_list;
        comment_list = commentService.viewCommentList(boardId);

        return comment_list;
    }


    //댓글 삭제
    @DeleteMapping("api/v1/board/{boardId}/{commentsId}")
    public void deleteComment(@PathVariable("boardId") Long boardId, @PathVariable("commentsId") Long commentId) {
        commentService.deleteComment(commentId);
    }

}
