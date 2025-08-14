package miniproject.demo.repository;


import miniproject.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Long countByBoard_BoardId(Long boardId);
}
