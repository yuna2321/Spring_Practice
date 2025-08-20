package miniproject.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long commentId; //기본키 댓글 고유 id

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable = false)
    private User user; //외래키 댓글 작성자

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="board_id", nullable = false)
    private Board board; //외래키 게시글

    @Column(nullable = false, length = 1000)
    private String content; //댓글 내용

    @Column(nullable = false)
    private LocalDateTime createdAt;  //생성일


    //user_id만
    public Long getUserId() {
        if(this.user == null) { return null; }
        return this.user.getUserId();
    }

    //board_id만
    public Long getBoardId() {
        if(this.board == null) { return null; }
        return this.board.getBoardId();
    }

}
