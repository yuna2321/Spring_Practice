package miniproject.demo.controller;


import lombok.RequiredArgsConstructor;
import miniproject.demo.DTO.LikeRequestDTO;
import miniproject.demo.DTO.LikeResponseDTO;
import miniproject.demo.service.LikeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/api/v1/board/{boardId}/like")
    public LikeResponseDTO pushLike(@PathVariable ("boardId") Long boardId, LikeRequestDTO likeRequestDTO) {
        LikeResponseDTO likeResponseDTO = null;

        if(likeRequestDTO.isLike()) {
           likeResponseDTO =  likeService.pushLike(likeRequestDTO);
        }
        else if(!likeRequestDTO.isLike()) {
            likeResponseDTO =  likeService.deleteLike(likeRequestDTO);
        }

        return likeResponseDTO;
    }

}
