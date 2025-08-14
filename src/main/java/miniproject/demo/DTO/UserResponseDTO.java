package miniproject.demo.DTO;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    private long userId; //사용자 id
    private String nickName; //사용자 닉네임
    private String profileImageURL; //프로필 사진 url

    private LocalDateTime joinedAt; //가입 날짜

}
