package miniproject.demo.DTO;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//클라이언트의 요청
public class CommentRequestDTO {

    Long userId;
    Long boardId;
    String content;

}
