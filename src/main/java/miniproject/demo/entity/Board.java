package miniproject.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long boardId; //기본키 boardID

    //User클래스 필드 모두를 가져오는게 아니라 일부만 가져옴
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;// 외래키 user

    @Column(nullable = false, length=200)
    private String title; //제목

    @Column(nullable  = false, length = 1000)
    private String content; //컨텐츠

    @Column(nullable = false)
    private LocalDateTime createdAt;  //생성일

    @Column(nullable = false)
    private LocalDateTime updatedAt; //수정일

    //user_id만
    public Long getUserId() {
        if(this.user == null) { return null; }
        return this.user.getUserId();
    }


    //수정메소드
    public void changeTitle(String title) { this.title = title;}
    public void changeContent(String content) {this.content = content; }
    public void changeUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}

}
