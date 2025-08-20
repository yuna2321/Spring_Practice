package miniproject.demo.repository;


import miniproject.demo.DTO.CommentResponseDTO;
import miniproject.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//DB와 직접 상호작용
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    //댓글 개수
    Long countByBoard_BoardId(Long boardId);

    //특정 게시글 조회
    List<Comment> findByBoard_BoardIdOrderByCreatedAtAsc(Long boardId);


}
