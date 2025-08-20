package miniproject.demo.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeRequestDTO {

    private boolean isLike;
    private Long userId; //좋아요를 누른 사용자
    private Long boardId;//좋아요를 누른 게시글


}
