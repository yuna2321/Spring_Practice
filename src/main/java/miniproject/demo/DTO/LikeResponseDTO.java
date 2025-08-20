package miniproject.demo.DTO;


import lombok.Builder;
import lombok.Getter;
import miniproject.demo.entity.Likes;

@Getter
@Builder
public class LikeResponseDTO {

    private boolean isLike;

    //Entity->DTO 변환
    public static LikeResponseDTO from(Likes likes) {
        return LikeResponseDTO.builder()
                .isLike(likes.isLike())
                .build();
    }
}
