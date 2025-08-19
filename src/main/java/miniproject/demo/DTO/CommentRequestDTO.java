package miniproject.demo.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
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
