package miniproject.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long userId; //사용자 id

    @Column(nullable = false, length=50)
    private String nickName; //사용자 닉네임

    @Column(nullable = false, length=200)
    private String email;

    @Column(nullable = false, length=50)
    private String password;

    @Column(length=200)
    private String profileImageURL; //프로필 사진 url

    @Column(nullable=false)
    private LocalDateTime joinedAt; //가입 날짜

    //의존성 주입해야 Authority 생김!!
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }



}
