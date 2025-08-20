package miniproject.demo.repository;

import miniproject.demo.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    Long countByBoard_BoardId(Long boardId);
}
