package miniproject.demo.controller;


import lombok.RequiredArgsConstructor;
import miniproject.demo.DTO.BoardCreateRequestDTO;
import miniproject.demo.DTO.BoardResponseDTO;
import miniproject.demo.DTO.CommentRequestDTO;
import miniproject.demo.DTO.CommentResponseDTO;
import miniproject.demo.entity.Comment;
import miniproject.demo.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 생성
    @PostMapping("/api/comments")
    public CommentResponseDTO createComment(@RequestBody CommentRequestDTO commentRequestDTO) {
        CommentResponseDTO commentResponseDTO;
        commentResponseDTO = commentService.createComment(commentRequestDTO);

        return commentResponseDTO;
    }

}
