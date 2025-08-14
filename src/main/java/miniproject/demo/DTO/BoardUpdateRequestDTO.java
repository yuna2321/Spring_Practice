package miniproject.demo.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//게시글 업데이트 요청
public class BoardUpdateRequestDTO {

    private String title;
    private String content;

}
