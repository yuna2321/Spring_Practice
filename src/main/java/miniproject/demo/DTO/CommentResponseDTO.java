package miniproject.demo.DTO;


import jakarta.persistence.*;
import lombok.*;
import miniproject.demo.entity.Board;
import miniproject.demo.entity.Comment;
import miniproject.demo.entity.User;

import java.time.LocalDateTime;

@Getter
@Builder
//서버의 응답
public class CommentResponseDTO {

    private Long commentId; //기본키 댓글 id
    private Long userId; //외래키 사용자
    private String content; //댓글 내용
    private LocalDateTime createdAt;


    //Entity -> DTO 변환 메서드
    //조회 등
    public static CommentResponseDTO from(Comment comment) {
        return CommentResponseDTO.builder()
                .commentId(comment.getCommentId())
                .userId(comment.getUser().getUserId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
