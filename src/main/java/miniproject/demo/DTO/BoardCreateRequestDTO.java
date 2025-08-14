package miniproject.demo.DTO;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//클라이언트로부터 생성요청을 받음
public class BoardCreateRequestDTO {

    private Long userId; //게시글 작성자
    private String title; //게시글 제목
    private String content; //게시글 본문

}
