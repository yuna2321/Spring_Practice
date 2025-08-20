package miniproject.demo.DTO;


import lombok.*;
import miniproject.demo.entity.Board;
import miniproject.demo.entity.User;

import java.time.LocalDateTime;

@Getter
@Builder
//클라이언트에게 응답
public class BoardResponseDTO {

    private Long boardId; // 게시글 고유 ID
    private Long userId; // 작성자 ID
    private String title; // 제목
    private String content; // 본문
    private LocalDateTime createdAt; //생성 시간
    private LocalDateTime updatedAt;//수정 시간
    private Long commentCount; //댓글 개수
    private Long likeCount; //좋아요 개수


    //Entity -> DTO 변환 메서드
    //조회 등
    public static BoardResponseDTO from(Board board, Long commentCount, Long likeCount) {
        return BoardResponseDTO.builder()
                .boardId(board.getBoardId())
                .userId(board.getUser().getUserId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .commentCount(commentCount)
                .likeCount(likeCount)
                .build();
    }
}
